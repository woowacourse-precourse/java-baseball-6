package baseball.domain;

public enum GameRules {
    START(1),
    END(9),
    INPUT_LIMIT(3);
    private final int value;
    GameRules(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
