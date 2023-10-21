package player;

import static constant.NumberConstant.MAX_LENGTH;
import static constant.StringConstant.NO_DUPLICATE_NUMBER_MESSAGE;
import static constant.StringConstant.ONLY_NUMBER_MESSAGE;
import static constant.StringConstant.ONLY_THREE_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements BaseballNumberInput {

    List<Integer> baseballNumbers = new ArrayList<>();

    @Override
    public void inputBaseballNumbers() {
        List<Integer> playerInputBaseballNumber = new ArrayList<>();
        String[] playerInput = Console.readLine().split("");

        for (String inputNumber : playerInput) {
            validateNumericInput(inputNumber);
            playerInputBaseballNumber.add(Integer.parseInt(inputNumber));
        }

        validateMaxLength(playerInputBaseballNumber);
        validateDuplicateNumber(playerInputBaseballNumber);
        baseballNumbers = playerInputBaseballNumber;
    }

    private void validateMaxLength(List<Integer> playerInput) {
        if (playerInput.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(ONLY_THREE_NUMBER_MESSAGE);
        }
    }

    private void validateDuplicateNumber(List<Integer> playerInput) {
        Set<Integer> playerBaseballNumberSet = new HashSet<>(playerInput);

        if (playerBaseballNumberSet.size() < MAX_LENGTH) {
            throw new IllegalArgumentException(NO_DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void validateNumericInput(String playerInput) {
        try {
            Double.parseDouble(playerInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }
}
