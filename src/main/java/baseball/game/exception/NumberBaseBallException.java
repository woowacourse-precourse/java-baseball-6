package baseball.game.exception;

public class NumberBaseBallException extends RuntimeException {

    public static final String NOT_FOUND = "생성된 숫자 야구 게임이 없습니다.";
    public static final String WRONG_NUMBER = "잘못 입력했습니다. 중복되지 않은 3자리 숫자를 입력해주세요.";

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

    protected NumberBaseBallException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
