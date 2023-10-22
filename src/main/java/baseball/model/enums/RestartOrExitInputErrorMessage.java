package baseball.model.enums;

public enum RestartOrExitInputErrorMessage {
    INVALID_LENGTH("입력이 1자리가 아닙니다."),
    INVALID_CHARACTER("1 또는 2의 입력이 아닙니다.");

    private String message;

    RestartOrExitInputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
