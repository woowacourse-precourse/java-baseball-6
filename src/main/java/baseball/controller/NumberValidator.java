package baseball.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidator {
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String WRONG_LEGNTH_NUMBER_MESSAGE = "세 자리 숫자를 입력해주세요.";
    private static final String WRONG_RANGE_NUMBER_MESSAGE = "1~9 사이의 숫자만 입력해주세요.";
    private static final String WRONG_SAME_NUMBER_MESSAGE = "서로 다른 세 자리 숫자만 입력해주세요.";
    private static final char BASEBALL_PLAYER_NUMBER_RANGE_START = '1';
    private static final char BASEBALL_PLAYER_NUMBER_RANGE_END = '9';

    public List<Integer> toValidateNumber(String inputNumber) {
        if (!isSameLength(inputNumber)) {
            throw new IllegalArgumentException(WRONG_LEGNTH_NUMBER_MESSAGE);
        } else if (!isSameRange(inputNumber)) {
            throw new IllegalArgumentException(WRONG_RANGE_NUMBER_MESSAGE);
        } else if (!isDiffNumber(inputNumber)) {
            throw new IllegalArgumentException(WRONG_SAME_NUMBER_MESSAGE);
        }
        return convertStringToIntList(inputNumber);
    }

    public boolean isSameLength(String inputNumber) {
        return inputNumber.length() == BASEBALL_NUMBER_LENGTH;
    }

    public boolean isSameRange(String inputNumber) {
        for (int i = 0; i < inputNumber.length(); i++) {
            if (!isCheckRange(inputNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isCheckRange(char checkChar) {
        return checkChar >= BASEBALL_PLAYER_NUMBER_RANGE_START
                && checkChar <= BASEBALL_PLAYER_NUMBER_RANGE_END;
    }

    public boolean isDiffNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");
        Set<String> setNumbers = Arrays.stream(numbers).collect(Collectors.toSet());

        return setNumbers.size() == BASEBALL_NUMBER_LENGTH;
    }

    public List<Integer> convertStringToIntList(String inputNumber) {
        int[] convertIntArray = Stream.of(inputNumber.split("")).mapToInt(Integer::parseInt).toArray();

        return Arrays.stream(convertIntArray).boxed().collect(Collectors.toList());
    }
}