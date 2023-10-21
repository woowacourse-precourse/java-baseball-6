package baseball.validator;


import static baseball.config.NumberConfig.NUMBER_LENGTH;

public class NumberValidator {
    public static void validateNumberLength(final String number) {
        if (!isValidLength(number)) {
            throw new IllegalArgumentException("number Length is different from the system setting");
        }
    }

    public static void validateContainDuplicatedNumber(final String number) {
        if (!isUniqueNumber(number)) {
            throw new IllegalArgumentException("number cannot contain duplicated numbers");
        }
    }

    public static void validateContainOnlyNumber(final String number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("number cannot contain any letters");
        }
    }

    public static void validateEmpty(final String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException("number cannot be empty");
        }
    }

    private static boolean isValidLength(final String number) {
        return number.length() == NUMBER_LENGTH.getValue();
    }

    private static boolean isValidNumber(final String number) {
        return number
                .chars()
                .allMatch(c -> Character.isDigit(c) && c >= '1' && c <= '9');
    }

    private static boolean isUniqueNumber(final String number) {
        return number.chars()
                .distinct()
                .count() == number.length();
    }
}
