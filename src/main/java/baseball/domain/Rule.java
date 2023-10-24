package baseball.domain;

import java.util.Arrays;

import static baseball.constants.ErrorMessage.*;
import static baseball.constants.GameOption.ANSWER_NUMBER_LENGTH;

public class Rule {
    public int[] validateUserInput(String input) {
        // 입력한 문자를 숫자 배열로 변환
        int[] inputNumbers = validateInputFormat(input);
        // 정답 길이와 일치하는 입력을 했는지 확인
        validateLength(inputNumbers);
        // 숫자 0을 포함하여 입력했는지 확인
        validateHasNotZero(inputNumbers);
        // 입력한 숫자에 중복한 수가 있는지 확인
        validateDuplicate(inputNumbers);

        return inputNumbers;
    }

    private int[] validateInputFormat(String input) {
        try {
            return Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            // 사용자가 입력한 문자에서 숫자로 변환될 수 없는 경우 발생하는 예외 처리
            throw new IllegalArgumentException(WRONG_INPUT_FORMAT.toString());
        }
    }

    private void validateLength(int[] inputNums) {
        if (inputNums.length != ANSWER_NUMBER_LENGTH.getLength()) {
            throw new IllegalArgumentException(WRONG_INPUT_LENGTH.toString());
        }
    }

    private void validateHasNotZero(int[] inputNumbers) {
        for (int inputNumber : inputNumbers) {
            if (inputNumber == 0) {
                throw new IllegalArgumentException(INPUT_HAS_ZERO.toString());
            }
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
