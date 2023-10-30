package racingcar.domain;

public class Position {
    private static final int INIT_POSITION = 0;
    private int value;
    public Position() {
        value = INIT_POSITION;
    }

    public void moveBy(int amount) {
        value += amount;
    }

    public int getValue() {
        return value;
    }
}
