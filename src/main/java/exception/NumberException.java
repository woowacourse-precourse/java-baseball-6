package exception;

import domain.Computer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberException {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final String LENGTH_ERROR_MESSAGE = "\nError: " + Computer.LENGTH + "개의 숫자를 입력해 주세요.";
    private static final String DUP_ERROR_MESSAGE = "\nError: 중복되지 않은 숫자를 입력해 주세요.";
    private static final String RANGE_ERROR_MESSAGE = "\nError: " + MIN_NUMBER + "부터 " + MAX_NUMBER + "까지 범위의 숫자를 입력해 주세요.";

    public static void numberException(String inputNumbers) {
        validateNumberLength(inputNumbers);
        validateNumberDup(inputNumbers);
        validateNumberRange(inputNumbers);
    }

    private static void validateNumberLength(String inputNumbers) {
        if (inputNumbers.length() != Computer.LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static void validateNumberDup(String inputNumbers) {
        Set<Character> set = new HashSet<>();
        for (char c : inputNumbers.toCharArray()) {
            if (!set.add(c)) {
                throw new IllegalArgumentException(DUP_ERROR_MESSAGE);
            }
        }
    }

    private static void validateNumberRange(String inputNumbers) {
        int[] numbers = Arrays.stream(inputNumbers.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
            }
        }
    }
}
