package baseball.exception;

public enum BaseBallGameException {

    RETRY_OR_EXIT_INPUT_FAILURE_EXCEPTION("[Error] 재시도는 1, 종료는 2 입니다."),
    INVALID_INPUT_OUT_OF_RANGE_EXCEPTION("[Error] 숫자는 1-9만 입력 가능합니다."),
    INVALID_INPUT_LENGTH_EXCEPTION("[Error] 숫자는 3자리만 입력해주세요.");

    private final String message;

    BaseBallGameException(String message) {
        this.message = message;
    }

    public IllegalArgumentException getException() throws IllegalStateException {
        throw new IllegalArgumentException(message);
    }

}
