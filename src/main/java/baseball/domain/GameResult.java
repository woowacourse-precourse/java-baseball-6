package baseball.domain;

import static baseball.domain.Ball.BALL_SIZE;

public record GameResult(int balls, int strikes) {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public String createGameResult() {
        if (isNothing()) {
            return NOTHING;
        }
        else if (isOnlyBall()) {
            return balls + BALL;
        }
        else if (isOnlyStrike()) {
            return strikes + STRIKE;
        }

        return toString();
    }

    private boolean isNothing() {
        return balls == 0 && strikes == 0;
    }

    private boolean isOnlyBall() {
        return balls > 0 && strikes == 0;
    }

    private boolean isOnlyStrike() {
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
