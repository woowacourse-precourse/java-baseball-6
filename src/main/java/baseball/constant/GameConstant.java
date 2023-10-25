package baseball.constant;

public enum GameConstant {

    NUMBER_START_INCLUSIVE(1),
    NUMBER_END_INCLUSIVE(9),
    NUMBER_COUNT(3),
    MAXIMUM_STRIKE_COUNT(3),
    REPLAY(1),
    QUIT(2);

    private final int constant;

    GameConstant(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
