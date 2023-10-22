package baseball.utility;

public class ExceptionHandler {

    private static ExceptionHandler exceptionHandler = new ExceptionHandler();

    private ExceptionHandler() {
    }

    public static ExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }
}
