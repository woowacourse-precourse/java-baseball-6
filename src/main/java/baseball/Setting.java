package baseball;

public enum Setting {
    BALL_SIZE(3),
    FIRST_NO(1),
    END_NO(9);

    private final int value;

    Setting(int value) {
        this.value = value;
    }

    public int get() {
        return this.value;
    }
}
