package baseball.common;

public enum GameStatus {
    CONTINUE("1"),
    EXIT("2");

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static GameStatus fromValue(String value) {
        for (GameStatus status : values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("입력 값에 해당하는 enum 값이 없습니다 : " + value);
    }
}
