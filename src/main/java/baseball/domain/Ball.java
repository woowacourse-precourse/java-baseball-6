package baseball.domain;

import java.util.List;

public class Ball {

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public MatchResult match(List<Ball> otherBalls) {
        for (Ball computer : otherBalls) {
            if (isStrike(computer)) {
                return MatchResult.STRIKE;
            }
            if (isBall(computer)) {
                return MatchResult.BALL;
            }
        }

        return MatchResult.NOTHING;
    }

    private boolean isStrike(Ball otherBall) {
        return isSameNumber(otherBall) && isSamePosition(otherBall);
    }

    private boolean isBall(Ball otherBall) {
        return isSameNumber(otherBall) && !isSamePosition(otherBall);
    }

    private boolean isSameNumber(Ball otherBall) {
        return this.number == otherBall.number;
    }

    private boolean isSamePosition(Ball otherBall) {
        return this.position == otherBall.position;
    }
}
