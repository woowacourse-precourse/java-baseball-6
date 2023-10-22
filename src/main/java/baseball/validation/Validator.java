package baseball.validation;

public class Validator {
    public static boolean isSize(final String target, final int size) {
        return target.length() == size;
    }
}
