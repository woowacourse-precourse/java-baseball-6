package baseball.enums;

public enum RestartEnum {
    RESTART("1"),
    END("2");

    private final String value;

    RestartEnum(String value) {
        this.value = value;
    }

    public static RestartEnum of(String value) {
        for (RestartEnum restart : RestartEnum.values()) {
            if (restart.value.equals(value)) {
                return restart;
            }
        }
        throw new IllegalArgumentException("재시작 여부는 1 또는 2만 입력 가능합니다.");
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
