package baseball.util;

public class ExceptionHandler {

    private static final String INPUT_EXCEPTION_MESSAGE = "잘못된 값을 입력했습니다.";

    public static void inputException() {
        throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
    }

}