package baseball.util;

public enum ErrorMessage {
    INVALID_GAME_INPUT_NUM("Exception Message : 1~9로 이루어진 서로 다른 세자리 수를 입력해주세요."),
    INVALID_RESTART_INPUT_NUM("Exception Message : 1 또는 2로 입력해주세요."),
    EMPTY_INPUT_ERROR("Exception Message : 공백을 입력하지 마세요.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }


}
