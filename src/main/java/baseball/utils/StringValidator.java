package baseball.utils;

public class StringValidator {

    private StringValidator() {
    }

    public static void validateHasLength(String source, int length) {
        if (source.length() != length) {
            throw new IllegalArgumentException(
                    "Length of %s is not %d but %d.".formatted(source, length, source.length()));
        }
    }

}
