package baseball.Domain;

public enum ConvertErrorMessage {
    PREFIX ("[ERROR] "),
    NOT_INTEGER("숫자만 입력해주세요."),
    NOT_3_INTEGER("3개의 숫자가 아닙니다."),
    NOT_1_OR_2("코인은 1 아니면 2로만 입력해야 합니다.");

    private final String message;

    ConvertErrorMessage(String message) {
        this.message =  message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
