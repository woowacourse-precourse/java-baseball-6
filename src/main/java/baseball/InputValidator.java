package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public void valid(String value) {
        isNotInteger(value);
        isZero(value);
        isNot3Digit(value);
        isNotDuplicate(value);
    }

    public void validRestartOrExit(String value) {
        if (!value.equals("1") && !value.equals("2")) {
            throw new IllegalArgumentException("재시작/종료를 위해서는 1 또는 2를 입력해주세요!");
        }
    }

    private void isNotInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private void isZero(String value) {
        for (char c : value.toCharArray()) {
            int number = c - '0';
            if (number == 0) {
                throw new IllegalArgumentException("자릿 수 값에 0이 존재합니다.");
            }
        }
    }

    private void isNot3Digit(String value) {
        if (value.length() != 3) {
            throw new IllegalArgumentException("자릿 수가 3자리 초과거나, 미만입니다.");
        }
    }

    private void isNotDuplicate(String value) {
        Set<Integer> duplicationTestSet = new HashSet<>();
        for (char c : value.toCharArray()) {
            int number = c - '0';
            duplicationTestSet.add(number);
        }

        if (duplicationTestSet.size() != 3) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다.");
        }
    }
}