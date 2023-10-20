package baseball.validator;

public class NumberValidator {

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
    }

    public static void validateNumberLength(final String number, final int numLength) {
        if (!isValidLength(number, numLength)) {
            throw new IllegalArgumentException(
                "number Length is different from the system setting");
        }
    }

    private static boolean isValidLength(final String number, int numLength) {
        return number.length() == numLength;
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
