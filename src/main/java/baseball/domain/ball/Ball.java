package baseball.domain.ball;

public class Ball {

    private Number number;
    private int position;

    public Ball(Number number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean isSameNumberAndSamePosition(Ball otherBall) {
        return this.number.isSameNumber(otherBall.number) && isSamePosition(otherBall.position);
    }

    private boolean isSamePosition(int otherPositon) {
        return this.position == otherPositon;
    }

    public boolean isSameNumberAndOtherPosition(Ball otherBall) {
        return this.number.isSameNumber(otherBall.number) && isOtherPosition(otherBall.position);
    }

    private boolean isOtherPosition(int otherPosition) {
        return this.position != otherPosition;
    }
}
