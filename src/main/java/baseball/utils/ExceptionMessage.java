package baseball.utils;

public enum ExceptionMessage {

    LENGTH("3자리 숫자를 입력해주세요."),

    NUMBER("숫자만 입력해주세요."),

    OVERLAP("서로 다른 임의의 수 3개를 입력해야 합니다."),

    INVALID("잘못된 값을 입력하셨습니다.");

    private final String code;

    ExceptionMessage(String code) {
        this.code = code;
    }

    // 지정된 enum 의 value 를 반환하는 메서드.
    public String getCode() {
        return code;
    }
}
