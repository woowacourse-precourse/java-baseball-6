package baseball.domain;

import static baseball.domain.Ball.BALL_SIZE;

public record GameResult(int balls, int strikes) {

    public boolean isNothing() {
        return balls == 0 && strikes == 0;
    }

    public boolean isOnlyBall() {
        return balls > 0 && strikes == 0;
    }

    public boolean isOnlyStrike() {
        return balls == 0 && strikes > 0;
    }

    public boolean isThreeStrike() {
        return strikes == BALL_SIZE;
    }

    @Override
    public String toString() {
        return balls + "볼 " + strikes + "스트라이크";
    }
}
