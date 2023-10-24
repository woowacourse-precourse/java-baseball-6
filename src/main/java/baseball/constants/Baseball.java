package baseball.constants;

public enum Baseball {
    GOAL(3),
    MAX_SIZE(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9),
    RESTART(1),
    QUIT(2)
    ;

    private Integer value;

    Baseball(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
