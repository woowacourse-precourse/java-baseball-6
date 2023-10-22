package baseball.domain;

public class Ball {

    private Number number;
    private int position;

    public Ball(Number number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean isSameNumberAndSamePosition(Ball otherBall) {
        return this.number.isSameNumber(otherBall.number) && this.position == otherBall.position;
    }
}
