package baseball.exception;

public interface ExceptionMessage {
    enum BaseballException {
        INVALID_BALL_COUNT("총 3개의 숫자가 필요합니다."),
        SPECIFIC_BALL_IS_NOT_IN_RANGE("숫자는 1..9 범위만 허용합니다."),
        EACH_BALL_MUST_BE_UNIQUE("중복된 숫자는 허용하지 않습니다."),
        ;

        public final String message;

        BaseballException(final String message) {
            this.message = message;
        }
    }

    enum GameProcessCommandException {
        INVALID_COMMAND("재시작[1] / 종료[2] 중 하나를 입력해주세요."),
        ;

        public final String message;

        GameProcessCommandException(final String message) {
            this.message = message;
        }
    }

    enum InputException {
        INPUT_MUST_NOT_CONTAINS_SPACE("공백없이 입력해주세요."),
        INPUT_MUST_BE_NUMERIC("숫자를 입력해주세요."),
        ;

        public final String message;

        InputException(final String message) {
            this.message = message;
        }
    }
}
