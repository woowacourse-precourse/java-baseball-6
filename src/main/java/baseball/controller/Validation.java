package baseball.controller;

import java.util.ArrayList;
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

    public void validateNumber(List<String> input) {
        for (String s : input) {
            int inputNum = Integer.parseInt(s);

            if (inputNum < 1 || inputNum > 9) {
                throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
            }
        }
    }

    public void validateDuplication(List<String> input) {
        List<String> check = new ArrayList<>();

        for (String s : input) {
            if (check.contains(s)) {
                throw new IllegalArgumentException("입력값은 중복될 수 없습니다.");
            }

            check.add(s);
        }
    }

    public void validateInputList(String input, int value) {
        validateInputLength(input, value);

        List<String> stringList = List.of(input.split(""));

        validateNumber(stringList);
        validateDuplication(stringList);
    }
}
