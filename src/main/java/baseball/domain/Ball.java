package baseball.domain;

public class Ball {
    private final int value;
    private final int position;

    public Ball(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public boolean isOnlySameValue(Ball other) {
        return this.position != other.position && this.value == other.value;
    }

    public boolean isSame(Ball other) {
        return this.value == other.value && this.position == other.position;
    }

    public int getValue() {
        return value;
    }
    public int getPosition() {
        return position;
    }

}
