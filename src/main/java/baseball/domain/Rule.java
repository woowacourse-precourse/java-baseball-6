package baseball.domain;

import java.util.Arrays;

import static baseball.constants.ErrorMessage.*;
import static baseball.constants.GameOption.ANSWER_NUMBER_LENGTH;

public class Rule {
    public int[] evaluateNumbers(String input) {
        int[] inputNums = validateInputFormat(input);
        validateLength(inputNums);
        validateDuplicate(inputNums);
        return inputNums;
    }

    private int[] validateInputFormat(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_INPUT_FORMAT.toString());
        }
    }

    private void validateLength(int[] inputNums) {
        if (inputNums.length != ANSWER_NUMBER_LENGTH.getLength()) {
            throw new IllegalArgumentException(WRONG_INPUT_LENGTH.toString());
        }
    }

    private void validateDuplicate(int[] inputNums) {
        long count = Arrays.stream(inputNums)
                .distinct()
                .count();

        if (inputNums.length != count) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_INPUT.toString());
        }
    }
}
