package baseball.validation;

public class Validator {
    public static boolean isSize(final String target, final int size) {
        return target.length() == size;
    }

    public static boolean isDigit(final String target) {
        for (char c : target.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
