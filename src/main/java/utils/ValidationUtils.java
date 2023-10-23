package utils;

public class ValidationUtils {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private ValidationUtils() {
    }

    public static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isSingleNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
