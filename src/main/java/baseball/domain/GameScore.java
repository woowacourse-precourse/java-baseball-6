package baseball.domain;

import static baseball.domain.Baseballs.BALL_SIZE;

public class GameScore {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    private int balls;
    private int strikes;

    public GameScore() {
        balls = 0;
        strikes = 0;
    }

    public void setGameScore(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public String generateGameResult() {
        if (isNothing()) {
            return NOTHING;
        }
        if (isOnlyBall()) {
            return balls + BALL;
        }
        if (isOnlyStrike()) {
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
