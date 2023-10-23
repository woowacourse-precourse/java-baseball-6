package baseball.global.exception;

public class CustomObjects {
    //throw IllegalArgumentException instead of NPE
    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
        return obj;
    }
}
