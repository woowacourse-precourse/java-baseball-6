package baseball.view;

public enum ErrorMessage {
    INVALID_NULL("값을 입력해 주세요."),
    INVALID_INTEGER("입력 값이 정수로 구성되지 않았습니다."),
    DUPLICATE_NUMBER("입력 값에 중복이 있습니다."),
    WRONG_DIGIT("입력이 %d자리 수가 아닙니다."),
    INVALID_CHOICE("게임 재시작은 %d, 종료는 %d입니다.");

    private final String message;

    ErrorMessage(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args){
        return String.format(message,args);
    }
}
