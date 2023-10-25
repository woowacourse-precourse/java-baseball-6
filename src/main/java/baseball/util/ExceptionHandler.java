package baseball.util;

public class ExceptionHandler {

    public static void triggerException(ErrorMessage message) {
        System.out.println("[오류] " + message.message);
        throw new IllegalArgumentException(message.message);
    }
}
