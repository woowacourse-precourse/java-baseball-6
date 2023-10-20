package baseball.controller;

import java.util.List;

public class Validation {

    private static final int CONTINUE = 1;
    private static final int END = 2;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;

    public static void validateInputLength(String input, int value) {
        if (input.length() != value) {
            throw new IllegalArgumentException(value + " 자리를 입력해야 합니다.");
        }
    }

    public static void validateOneOrTwo(int inputNum) {
        if (inputNum != CONTINUE && inputNum != END) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }
    }

    public static void validateNumber(int inputNum) {
        if (inputNum < MIN_NUM || inputNum > MAX_NUM) {
            throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
        }
    }

    public static void validateDuplication(List<Integer> inputList, int inputNum) {
        if (inputList.contains(inputNum)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
        }
    }
}
