package baseball.exception;

public interface ExceptionMessage {
    enum BaseballException {
        SPECIFIC_BALL_IS_NOT_IN_RANGE("숫자는 1..9 범위만 허용합니다."),
        ;

        public final String message;

        BaseballException(final String message) {
            this.message = message;
        }
    }
}
