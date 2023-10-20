package baseball.exception;

public enum ExceptionCode {
    NO_RESULT("View-001", "게임 결과가 존재하지 않습니다."),

    ;

    private final String code;
    private final String description;

    ExceptionCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ExceptionCode{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
