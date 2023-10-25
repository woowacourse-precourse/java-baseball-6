package baseball.exception;

public enum ExceptionCode {
    NO_RESULT("View-001", "게임 결과가 존재하지 않습니다."),

    NOT_GAMEDATA_TYPE("Service-001", "GameData가 BaseballNumber이 아닙니다.");

    private final String code;
    private final String description;

    ExceptionCode(final String code, final String description) {
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
