package baseball.game;

import baseball.ball.Balls;
import baseball.ball.BaseBallStatus;
import baseball.ball.Result;

public class GameResult {
    public static final int NO_SCORE = 0;
    private int ballCount;
    private int strikeCount;

    public GameResult() {
        this.ballCount = NO_SCORE;
        this.strikeCount = NO_SCORE;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void plusScore(Result result) {
        if (result.isBall()) {
            ballCount++;
        }

        if (result.isStrike()) {
            strikeCount++;
        }
    }

    public boolean isNothing() {
        return ballCount == NO_SCORE && strikeCount == NO_SCORE;
    }

    public BaseBallStatus isWinCondition() {
        if (isGameWin()) {
            return BaseBallStatus.CORRECT;
        }
        return BaseBallStatus.GUESSING;
    }

    public boolean isGameWin() {
        return strikeCount == Balls.BALLS_SIZE;
    }

    public boolean hasBallCount() {
        return this.ballCount > 0;
    }

    public boolean hasStrikeCount() {
        return this.strikeCount > 0;
    }
}
