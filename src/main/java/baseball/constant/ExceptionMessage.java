package baseball.constant;

/**
 * {@summary Exception발생 시 사용할 오류 메세지를 다룬다.}
 */
public enum ExceptionMessage {
    LENGTH("입력한 수의 길이가 길거나 짧습니다."),
    TYPE("잘못된 입력 형식입니다.");

    private final String value;

    ExceptionMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
