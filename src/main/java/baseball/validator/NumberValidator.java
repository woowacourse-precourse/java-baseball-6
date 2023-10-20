package baseball.validator;

import static baseball.config.Config.NUMBER_LENGTH;

public class NumberValidator {

    /**
     * validateNumber 유효한 숫자 인자인지 검증하는 메소드
     * - number 객체가 비어있는지 검증 -> 비어있다면 예외를 던진다.
     * - number 객체가 숫자만 포함하고 있는지 검증 -> 아니라면 예외를 던진다.
     * - number 객체가 중복된 숫자를 포함하고 있는지 검증 -> 아니라면 예외를 던진다.
     * @param number
     */
    public static void validateNumber(final String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("number cannot be empty");
        }
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("number cannot contain any letters");
        }
        if (!isUniqueNumber(number)) {
            throw new IllegalArgumentException("number cannot contain duplicated numbers");
        }
        if (!isValidLength(number)) {
            throw new IllegalArgumentException(
                "number Length is different from the system setting");
        }
    }

    private static boolean isValidLength(final String number) {
        return number.length() == NUMBER_LENGTH;
    }

    private static boolean isValidNumber(final String number) {
        return number
            .chars()
            .allMatch(c -> Character.isDigit(c) && c >= '1' && c <= '9');
    }

    private static boolean isUniqueNumber(final String number) {
        return number.chars().distinct().count() == number.length();
    }
}
