package baseball.config;

public class Config {
    private static final int GAME_SIZE = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public int getMinValue() {
        return MIN_VALUE;
    }
    public int getMaxValue() {
        return MAX_VALUE;
    }
    public int getGameSize() {
        return GAME_SIZE;
    }
}
