package baseball.controller;

import java.util.List;

public class Validation {

    public void validateInputLength(String input, int value) {
        if (input.length() != value) {
            throw new IllegalArgumentException(value + " 자리를 입력해야 합니다.");
        }
    }

    public void validateOneOrTwo(int inputNum) {
        if (inputNum != 1 && inputNum != 2) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }
    }

    public void validateNumber(int inputNum) {
        if (inputNum < 1 || inputNum > 9) {
            throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
        }
    }

    public void validateDuplication(List<Integer> inputList, int inputNum) {
        if (inputList.contains(inputNum)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
        }
    }
}
