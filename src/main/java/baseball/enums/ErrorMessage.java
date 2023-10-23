package baseball.enums;

public enum ErrorMessage {
    NUMBER_LENGTH_ERROR("3자리의 수를 입력하시오."),
    REGEX_ERROR("숫자 외에 다른 문자가 존재합니다."),
    DUPLICATED_ERROR("입력에 중복되는 숫자가 존재합니다.");

    private final String msg;

    ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
