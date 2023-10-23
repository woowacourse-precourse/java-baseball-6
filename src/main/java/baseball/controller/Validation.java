package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public static void validateOneOrTwo(String input, int validLen) {
        Validation.validateInputStyle(input, validLen);

        int inputNum = Integer.parseInt(input);
        Validation.validateOneOrTwoNumber(inputNum);
    }

    public static void validateNumberString(String input, int validLen) {
        Validation.validateInputStyle(input, validLen);
        Validation.validateDuplication(input);
    }

    public static void validateInputStyle(String input, int validLen) {
        Validation.validateInputLength(input, validLen);
        Validation.validateNumber(input);
    }

    public static void validateInputLength(String input, int value) {
        if (input.length() != value) {
            throw new IllegalArgumentException(value + " 자리를 입력해야 합니다.");
        }
    }

    public static void validateNumber(String input) {
        char[] arr = input.toCharArray();

        for (char c : arr) {
            int inputNum = Character.getNumericValue(c);

            if (inputNum < 1 || inputNum > 9) {
                throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
            }
        }
    }

    public static void validateOneOrTwoNumber(int inputNum) {
        if (inputNum != 1 && inputNum != 2) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }
    }

    public static void validateDuplication(String input) {
        List<String> stringList = List.of(input.split(""));
        List<String> check = new ArrayList<>();

        for (String s : stringList) {
            if (check.contains(s)) {
                throw new IllegalArgumentException("입력값은 중복될 수 없습니다.");
            }

            check.add(s);
        }
    }
}
