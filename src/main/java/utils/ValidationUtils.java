package utils;

public class ValidationUtils {

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
}
