package baseball.utils;

public enum ErrorMessage {

    USER_INSERT_ONLY_NUMBER("[ERROR] 숫자만 입력 가능합니다"),
    USER_INSERT_NUMBER_NOT_DUPLICATION("[ERROR] 중복된 숫자는 입력 불가합니다"),
    USER_INSERT_NUMBER_SIZE_THREE("[ERROR] 숫자는 3자리 숫자만 가능합니다"),
    INSERT_USER_NUMBER_SIZE_ERROR("[ERROR] 숫자의 범위는 1-9까지입니다"),
    INSERT_USER_RESTART_COMMAND_ERROR("[ERROR] 1,2만 입력 가능합니다");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
