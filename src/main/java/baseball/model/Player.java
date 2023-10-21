package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.common.exception.ExceptionMessage.*;


public class Player {
    private List<Integer> playerNumbers;

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(String playerInputNumbers) {
        validatePlayerInput(playerInputNumbers);

        this.playerNumbers = Arrays.stream(playerInputNumbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validatePlayerInput(String playerInputNumbers) {
        /*
          - 3자리가 아닌 경우
          - 숫자가 중복된 경우
          - 0이거나 숫자가 아닌 경우
        * */
        if (playerInputNumbers.length() != 3) {
            throw new IllegalArgumentException(INPUT_NOT_INCLUDE_3_WORD.message());
        }

        Set<Integer> numbers = Arrays.stream(playerInputNumbers.split(""))
                .filter(Player::isInputNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        if (numbers.size() != 3) {
            throw new IllegalArgumentException(INPUT_INCLUDE_DUPLICATED_NUMBER.message());
        }
    }

    private static boolean isInputNumeric(String string) {
        try {
            int number = Integer.parseInt(string);
            if (number == 0) {
                throw new IllegalArgumentException(INPUT_INCLUDE_ZERO.message());
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_INCLUDE_NON_NUMBER.message());
        }
    }

}
