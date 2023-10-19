package baseball.exception;

public interface ExceptionMessage {
    enum BaseballException {
        SPECIFIC_BALL_IS_NOT_IN_RANGE("숫자는 1..9 범위만 허용합니다."),
        EACH_BALL_MUST_BE_UNIQUE("중복된 숫자는 허용하지 않습니다."),
        ;

        public final String message;

        BaseballException(final String message) {
            this.message = message;
        }
    }
}
