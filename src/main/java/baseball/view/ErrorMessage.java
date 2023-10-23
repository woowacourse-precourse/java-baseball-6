package baseball.view;

public enum ErrorMessage {
    INVALID_NULL("값을 입력해 주세요."),
    INVALID_INTEGER("입력 값이 정수로 구성되지 않았습니다."),
    DUPLICATE_NUMBER("입력 값에 중복이 있습니다."),
    WRONG_DIGIT("입력이 3자리 수가 아닙니다."),
    INVALID_CHOICE("게임 재시작은 1, 종료는 2입니다.");

    private final String message;

    ErrorMessage(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
