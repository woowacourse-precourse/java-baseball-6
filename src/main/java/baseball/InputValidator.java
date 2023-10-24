package baseball;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {

    public static final String RESTART_OR_EXIT_ERROR_MESSAGE = "재시작/종료를 위해서는 1 또는 2를 입력해주세요!";
    public static final String NOT_INT_ERROR_MESSAGE = "숫자가 아닙니다.";
    public static final String CONTAINS_ZERO_ERROR_MESSAGE = "자릿 수 값에 0이 존재합니다.";
    public static final String NOT_THREE_DIGIT_ERROR_MESSAGE = "자릿 수가 3자리 초과거나, 미만입니다.";
    public static final char ZERO = '0';
    public static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복되는 숫자가 존재합니다.";
    public static final String RESTART_NUMBER = "1";
    public static final String EXIT_NUMBER = "2";

    public void valid(String value) {
        isNotInteger(value);
        isZero(value);
        isNot3Digit(value);
        isNotDuplicate(value);
    }

    public void validRestartOrExit(String value) {
        if (!value.equals(RESTART_NUMBER) && !value.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException(RESTART_OR_EXIT_ERROR_MESSAGE);
        }
    }

    private void isNotInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INT_ERROR_MESSAGE);
        }
    }

    private void isZero(String value) {
        for (char c : value.toCharArray()) {
            int number = c - ZERO;
            if (number == 0) {
                throw new IllegalArgumentException(CONTAINS_ZERO_ERROR_MESSAGE);
            }
        }
    }

    private void isNot3Digit(String value) {
        if (value.length() != 3) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT_ERROR_MESSAGE);
        }
    }

    private void isNotDuplicate(String value) {
        Set<Integer> duplicationTestSet = new HashSet<>();
        for (char c : value.toCharArray()) {
            int number = c - ZERO;
            duplicationTestSet.add(number);
        }

        if (duplicationTestSet.size() != 3) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }
}