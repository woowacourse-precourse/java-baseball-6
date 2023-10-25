package baseball.message;

public enum ErrorMessage {
    DUPLICATE_NUMBER("[ERROR] 중복되는 숫자가 존재합니다."),
    NUMBER_NOT_3("[ERROR] 숫자가 3개가 아닙니다."),
    NOT_RANGE_NUMBER("[ERROR] 숫자의 범위가 잘못되었습니다."),
    NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    WRONG_GAMEFLAG("[ERROR] 올바르지 않은 입력입니다.");

    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
