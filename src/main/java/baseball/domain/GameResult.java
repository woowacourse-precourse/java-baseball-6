package baseball.domain;

import static baseball.domain.Ball.BALL_SIZE;

public record GameResult(int balls, int strikes) {
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";
    public static final String RESTART = "1";
    public static final String EXIT = "2";

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
        return balls + BALL + " " + strikes + STRIKE;
    }
}
