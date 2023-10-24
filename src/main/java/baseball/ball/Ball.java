package baseball.ball;

public class Ball {
    private final Number number;
    private final Index index;

    public Ball(Number number, Index index) {
        this.number = number;
        this.index = index;
    }

    public Number getNumber() {
        return number;
    }

    public Index getIndex() {
        return index;
    }

    public Result compareWithOtherBall(Ball otherBall) {
        if (isSameNumberAndIndex(otherBall)) {
            return Result.STRIKE;
        }

        if (isSameNumber(otherBall)) {
            return Result.BALL;
        }

        return Result.NOTHING;
    }

    private boolean isSameNumberAndIndex(Ball otherBall) {
        return number.isEqualTo(otherBall.getNumber()) && index.isEqualTo(otherBall.getIndex());
    }

    private boolean isSameNumber(Ball otherBall) {
        return number.isEqualTo(otherBall.getNumber());
    }
}
