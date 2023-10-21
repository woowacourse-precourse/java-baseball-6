package baseball.controller;

public enum RestartCode {
    RESTART("1"),
    EXIT("2");

    private final String code;

    RestartCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
