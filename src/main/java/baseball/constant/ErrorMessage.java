package baseball.constant;

public enum ErrorMessage {

    NUMBER_FORMAT_ERROR("올바르지 않은 숫자 형식입니다."),
    REPLAY_COMMAND_ERROR("유효하지 않은 명령어 입니다."),
    ;
    private final String error;

    ErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
