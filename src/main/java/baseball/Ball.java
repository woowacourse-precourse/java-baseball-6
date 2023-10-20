package baseball;

public class Ball {

    private final int value;
    private final int ord;

    public Ball(int value, int ord) {
        GameUtil.validateValue(value);
        this.value = value;
        this.ord = ord;
    }

    public BallStatus compare(Ball otherBall) {
        if(this.value == otherBall.getValue() && this.ord == otherBall.getOrd()) return BallStatus.STRIKE;
        else if(this.value == otherBall.getValue() && this.ord != otherBall.getOrd()) return BallStatus.BALL;
        return BallStatus.NOTHING;
    }

    public int getValue() {
        return value;
    }

    public int getOrd() {
        return ord;
    }
}
