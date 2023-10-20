package baseball.model;

import baseball.view.Input;
import baseball.view.Output;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.common.exception.ExceptionMessage.*;


public class Player {
    private List<Integer> playerNumbers;

    public void getPlayerInput() {
        String playerInputNumbers = Input.playerInputNumbers();
        validatePlayerInput(playerInputNumbers);

        setNumbers(playerInputNumbers);
    }

    public void setNumbers(String playerInputNumbers) {
        this. playerNumbers = Arrays.stream(playerInputNumbers.split(""))
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
            Output.printTerminated(INPUT_NOT_INCLUDE_3_WORD);
            throw new IllegalArgumentException();
        }

        Set<Integer> numbers = Arrays.stream(playerInputNumbers.split(""))
                .filter(Player::isInputNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        if (numbers.size() != 3) {
            Output.printTerminated(INPUT_INCLUDE_DUPLICATED_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInputNumeric(String string) {
        try {
            int number = Integer.parseInt(string);
            if (number == 0) {
                Output.printTerminated(INPUT_INCLUDE_ZERO);
                throw new IllegalArgumentException();
            }
            return true;
        } catch (NumberFormatException e) {
            Output.printTerminated(INPUT_INCLUDE_NON_NUMBER);
            throw new IllegalArgumentException();
        }
    }

}
