package baseball.enums;

public enum ApplicationMessage {

    EXCEPTION_OCCURRED_MESSAGE("예외가 발생하여 프로그램을 종료합니다."),
    ;

    private final String message;

    ApplicationMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
