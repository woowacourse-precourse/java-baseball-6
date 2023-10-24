package baseball.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationService {
    private final char START_INCLUSIVE_NUMBER_CHAR;
    private final char END_INCLUSIVE_NUMBER_CHAR;
    private final int SIZE_NUMBER;

    public ValidationService(int startInclusive, int endInclusive, int size) {
        START_INCLUSIVE_NUMBER_CHAR = (char) startInclusive;
        END_INCLUSIVE_NUMBER_CHAR = (char) endInclusive;
        SIZE_NUMBER = size;
    }
    public void inputNumberValidation(String inputNumber) {
        // 세 자리 글자 인지 확인
        if (isNotThreeCharacters(inputNumber)) {
            throw new IllegalArgumentException();
        }
        // 숫자인지 확인
        if (isNotNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        // 서로 다른 글자 인지 확인
        if (isNotDifferentChar(inputNumber)) {
            throw new IllegalArgumentException();
        }
    }

    // 겹치는 숫자가 있으면 true
    private boolean isNotDifferentChar(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());
        return setNumbers.size() != SIZE_NUMBER;
    }

    // 숫자로 이루어져있지 않으면 true
    private boolean isNotNumber(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) <= START_INCLUSIVE_NUMBER_CHAR && inputNumber.charAt(i) >= END_INCLUSIVE_NUMBER_CHAR) {
                return true;
            }
        }

        return false;
    }

    // 세 글자가 아니면 true
    private boolean isNotThreeCharacters(String inputNumber) {
        return inputNumber.length() != SIZE_NUMBER;
    }

    public boolean inputRestartValidation(String inputNumber) {
        // 숫자 1인지 확인
        if (inputNumber.equals("1")) {
            return true;
        } else if (inputNumber.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
