package baseball.domain;

import java.util.List;

public class NumberBall {

    private final int position;
    private final int number;

    public NumberBall(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public MatchResult match(List<NumberBall> otherNumberBalls) {
        for (NumberBall computer : otherNumberBalls) {
            if (isStrike(computer)) {
                return MatchResult.STRIKE;
            }
            if (isBall(computer)) {
                return MatchResult.BALL;
            }
        }

        return MatchResult.NOTHING;
    }

    private boolean isStrike(NumberBall otherNumberBall) {
        return isSameNumber(otherNumberBall) && isSamePosition(otherNumberBall);
    }

    private boolean isBall(NumberBall otherNumberBall) {
        return isSameNumber(otherNumberBall) && !isSamePosition(otherNumberBall);
    }

    private boolean isSameNumber(NumberBall otherNumberBall) {
        return this.number == otherNumberBall.number;
    }

    private boolean isSamePosition(NumberBall otherNumberBall) {
        return this.position == otherNumberBall.position;
    }
}
