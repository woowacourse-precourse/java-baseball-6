package baseball.controller;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidator {
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String WRONG_LEGNTH_NUMBER_MESSAGE = "세 자리 숫자가 아닙니다."; 
    private static final String WRONG_RANGE_NUMBER_MESSAGE = "1~9 사이의 숫자만 입력해주세요.";
    private static final String WRONG_SAME_NUMBER_MESSAGE = "서로 다른 세 자리 숫자만 입력해주세요.";

    public int[] toValidateNumber(String inputNumber) {
        if (!isSameLength(inputNumber)) {
            throw new IllegalArgumentException(WRONG_LEGNTH_NUMBER_MESSAGE);
        } else if (!isSameRange(inputNumber)) {
            throw new IllegalArgumentException(WRONG_RANGE_NUMBER_MESSAGE);
        } else if (!isDiffNumber(inputNumber)) {
            throw new IllegalArgumentException(WRONG_SAME_NUMBER_MESSAGE);
        }
        return convertStringToIntArray(inputNumber);
    }

    public boolean isSameLength(String inputNumber) {
        return inputNumber.length() == BASEBALL_NUMBER_LENGTH;
    }

    public boolean isSameRange(String inputNumber) {
        return inputNumber.chars().allMatch(Character::isDigit);
    }

    public boolean isDiffNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == BASEBALL_NUMBER_LENGTH;
    }

    public int[] convertStringToIntArray(String inputNumber) {
        return Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).toArray();
    }
}