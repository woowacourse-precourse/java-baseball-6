package baseball.util;

import baseball.constant.ContinueFlag;

import java.util.HashSet;
import java.util.Set;

public class InputValueValidator {

    private InputValueValidator() {
    }

    public static void checkValidInputAnswer(String inputAnswer, int numberOfDigits) {
        checkBlank(inputAnswer);
        checkIsNumber(inputAnswer);
        checkCorrectNumberOfDigits(inputAnswer, numberOfDigits);
        checkAnyDuplicateNumber(inputAnswer);
    }

    public static void checkValidInputContinueFlag(String inputContinueFlag) {
        checkBlank(inputContinueFlag);
        checkCorrectContinueFlag(inputContinueFlag);
    }

    private static void checkBlank(String inputValue) {
        if (inputValue == null || inputValue.isEmpty() || inputValue.isBlank()) {
            throw new IllegalArgumentException("Error: 빈 문자열 입력");
        }
        for (char c : inputValue.toCharArray()) {
            if (Character.isWhitespace(c)) {
                throw new IllegalArgumentException("Error: 입력에 공백 포함");
            }
        }
    }

    private static void checkIsNumber(String inputValue) {

        for (char c : inputValue.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Error: 숫자가 아닌 값 입력");
            }
        }
    }

    private static void checkCorrectNumberOfDigits(String inputValue, int numberOfDigits) {
        if (inputValue.length() != numberOfDigits) {
            throw new IllegalArgumentException("Error: 자리 수 다르게 입력, " + numberOfDigits + " 자리 수 숫자 입력 부탁드립니다.");
        }
    }

    private static void checkAnyDuplicateNumber(String inputValue) {
        Set<Character> digitSet = new HashSet<>();
        for (char c : inputValue.toCharArray()) {
            if (digitSet.contains(c)) {
                throw new IllegalArgumentException("Error: 중복된 숫자 입력");
            } else {
                digitSet.add(c);
            }
        }
    }

    private static void checkCorrectContinueFlag(String inputValue) {
        if (!inputValue.equals(String.valueOf(ContinueFlag.CONTINUE.getValue())) && !inputValue.equals(
                String.valueOf(ContinueFlag.DONE.getValue()))) {
            String message = String.format("Error: %d or %d 만 입력 가능합니다.", ContinueFlag.CONTINUE.getValue(), ContinueFlag.DONE.getValue());
            throw new IllegalArgumentException(message);
        }
    }
}
