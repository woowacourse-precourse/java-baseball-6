package baseball.ball;

public enum BallBoundary {
    MAX_VALUE(9),MIN_VALUE(1);
    private final int value;
    BallBoundary(int value) {this.value = value;}
    public int getValue(){return value;}
}
