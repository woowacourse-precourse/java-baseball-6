package baseball.validator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberValidator {

    public static final int LENGTH = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private NumberValidator() {
        throw new IllegalArgumentException("NumberValidator(): 인스턴스 생성 불가능");
    }

    public static void validateNaturalNumber(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("숫자는 " + MIN_VALUE + "에서 " + MAX_VALUE + "까지여야 합니다.");
        }
    }

    public static void validateDuplicateNumber(int number) {
        String numberString = String.valueOf(number);
        Set<Character> characters = convertStringToSet(numberString);
        if (characters.size() < numberString.length()) {
            throw new IllegalArgumentException(number + ": 중복된 숫자가 존재합니다.");
        }
    }

    public static void validateAllDigits(String input) {
        for (char c : input.toCharArray()) {
            validateEachDigit(input, c);
        }
    }

    private static void validateEachDigit(String input, char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(input + "은 숫자가 아닙니다.");
        }
    }

    private static Set<Character> convertStringToSet(String numberString) {
        Set<Character> resultSet = new HashSet<>();
        for (char c : numberString.toCharArray()) {
            resultSet.add(c);
        }

        return resultSet;
    }

    public static void validateRequiredLength(String input) {
        if (Objects.equals(input, "1") || Objects.equals(input, "2")) {
            return;
        }

        if (input.length() != LENGTH) {
            throw new IllegalArgumentException(input + "의 길이는 " + LENGTH + "이어야 합니다.");
        }
    }

    public static boolean isBelowRequiredLength(int size) {
        return size < LENGTH;
    }

}
