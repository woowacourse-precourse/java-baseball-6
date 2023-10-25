package baseball.constant;

public enum Rule {
    SIZE(3),
    START(1),
    END(9);

    private final int value;

    Rule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
