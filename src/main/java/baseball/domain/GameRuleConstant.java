package baseball.domain;

public enum GameRuleConstant {
    GAME_NUMBER_SIZE(3),
    GAME_NUMBER_MIN(1),
    GAME_NUMBER_MAX(9),
    STRIKE_OUT(3);

    private final int number;

    GameRuleConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
