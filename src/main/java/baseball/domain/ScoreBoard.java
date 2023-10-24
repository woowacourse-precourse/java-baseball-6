package baseball.domain;

import static baseball.domain.Baseballs.BALL_SIZE;

public class ScoreBoard {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private int balls;
    private int strikes;

    public ScoreBoard() {
        balls = 0;
        strikes = 0;
    }

    public int getBalls() {
        return balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public void setScoreBoard(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

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
