package baseball.game.exception;

public class NumberBaseBallException extends RuntimeException {

    public static String NOT_FOUND = "생성된 숫자 야구 게임이 없습니다.";

    public NumberBaseBallException() {
        super();
    }

    public NumberBaseBallException(String message) {
        super(message);
    }

    public NumberBaseBallException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberBaseBallException(Throwable cause) {
        super(cause);
    }

    protected NumberBaseBallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
