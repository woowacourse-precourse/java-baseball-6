package baseball.services;

public class InputExceptionError {
    public static void throwIllegalArgumentException() {
        throw new IllegalArgumentException(Constants.ERROR_MESSAGE);
    }
}
