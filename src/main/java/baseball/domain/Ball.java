package baseball.domain;

public class Ball {

    private final int number;
    private final int position;

    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public MatchResult match(Ball otherBall) {
        if (isStrike(otherBall)) {
            return MatchResult.STRIKE;
        }

        if (isBall(otherBall)) {
            return MatchResult.BALL;
        }

        return MatchResult.NOTHING;
    }

    public boolean isStrike(Ball otherBall) {
        return isSameNumber(otherBall) && isSamePosition(otherBall);
    }

    public boolean isBall(Ball otherBall) {
        return !isSamePosition(otherBall) && isSameNumber(otherBall);
    }

    private boolean isSameNumber(Ball otherBall) {
        return this.position == otherBall.position;
    }

    private boolean isSamePosition(Ball otherBall) {
        return this.number == otherBall.number;
    }
}
