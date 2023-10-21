package baseball.common.exception;

public enum ExceptionMessage {
    INPUT_NOT_INCLUDE_3_WORD("3개의 숫자가 아닌 입력입니다."),
    INPUT_INCLUDE_DUPLICATED_NUMBER("중복된 숫자를 포함한 입력입니다."),
    INPUT_INCLUDE_NON_NUMBER("숫자가 아닌 문자를 포함한 입력입니다."),
    INPUT_INCLUDE_ZERO("0을 포함한 입력입니다."),
    ILLEGAL_INPUT_FOR_STATUS("게임 재시작 또는 종료를 위한 입력이 아닙니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
