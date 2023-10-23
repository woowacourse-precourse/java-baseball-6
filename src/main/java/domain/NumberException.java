package domain;

import java.util.HashSet;
import java.util.Set;

public class NumberException {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static void numberException(String inputNumbers) {
        validateNumberLength(inputNumbers);
        validateNumberDup(inputNumbers);
        validateNumberRange(inputNumbers);
    }

    private static void validateNumberLength(String inputNumbers) {
        if (inputNumbers.length() != Computer.LENGTH) {
            throw new IllegalArgumentException("\nError: " +  Computer.LENGTH + "개의 숫자를 입력해 주세요.");
        }
    }

    private static void validateNumberDup(String inputNumbers) {
        Set<Character> set = new HashSet<>();
        for (char c : inputNumbers.toCharArray()) {
            if (!set.add(c)) {
                throw new IllegalArgumentException("\nError : 중복 되지 않은 숫자를 입력해 주세요.");
            }
        }
    }

    private static void validateNumberRange(String inputNumbers) {
        String[] numbers = inputNumbers.split("");
        for (int i=0;i<numbers.length;i++) {
            if (Integer.parseInt(numbers[i]) < MIN_NUMBER || Integer.parseInt(numbers[i]) > MAX_NUMBER) {
                throw new IllegalArgumentException("\nError : 1부터 9까지의 범위를 가진 숫자를 입력해 주세요.");
            }
        }
    }
}
