package baseball.core.code;


public enum ErrorMessage {
    INPUT_NOT_BLANK("숫자를 입력 해야 합니다."),
    INPUT_NOT_NUMBER("숫자만 입력 해야 합니다."),
    INPUT_ONLY_3("숫자는 3자리로 입력 해야 합니다."),
    INPUT_NOT_DUPLICATED("숫자는 중복 될 수 없습니다."),
    INPUT_ONLY_1_OR_2("1 또는 2만 입력 가능합니다."),
    ;

    private String description;

    private ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
