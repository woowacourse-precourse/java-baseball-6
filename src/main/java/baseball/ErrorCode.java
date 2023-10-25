package baseball;

public enum ErrorCode {
    INVALID_PLAY_NUMBER("유효하지 않은 게임 수를 입력하였습니다."),
    INVALID_TERMINATE_NUMBER("유요하지 않은 종료 수를 입력하였습니다");

    private final String message;

    private ErrorCode(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}
