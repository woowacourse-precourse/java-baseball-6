package baseball.domain;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
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
        return isSameNumber(otherBall) && !isSamePosition(otherBall);
    }

    private boolean isSameNumber(Ball otherBall) {
        return this.number == otherBall.number;
    }

    private boolean isSamePosition(Ball otherBall) {
        return this.position == otherBall.position;
    }
}
