package baseball.util;

public class ExceptionUtil {

    public static void throwInvalidValueException() {
        throw new IllegalArgumentException();
    }

    public static void throwInvalidValueException(String message) {

        throw new IllegalArgumentException(message);
    }

}
