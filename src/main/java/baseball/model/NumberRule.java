package baseball.model;

public enum NumberRule {

    GAME_NUMBER_SIZE(3),
    GAME_NUMBER_RANGE_START(1),
    GAME_NUMBER_RANGE_END(9);

    private int number;

    NumberRule(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
