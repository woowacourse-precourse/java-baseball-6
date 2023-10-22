package baseball.model.message;

public enum ErrorMessage {

    INVALID_NUMBERS_LENGTH("숫자의 자리수를 맞춰서 입력해주세요."),
    INVALID_RANGE("숫자의 범위를 알맞게 입력해주세요."),
    DUPLICATED_NUMBER("숫자들은 중복될 수 없습니다."),
    INVALID_INPUT("입력을 해주세요."),
    INVALID_NUMBER("문자, 특수기호 등을 제외한 숫자를 입력해주세요."),
    POSITIVE_NUMBER_NEED("양수의 숫자를 입력해주세요."),
    INVALID_REPLAY_STATUS("알맞은 재시작/종료 입력을 해주세요."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
