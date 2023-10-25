package baseball.model;

import baseball.model.ball.BallStatus;

public class Hint extends BaseballGameRule {

    int strikeCount = NO_HIT;
    int ballCount = NO_HIT;

    public void report(BallStatus ballStatus) {
        if (ballStatus.isNothing()) {
            return;
        }
        if (ballStatus.isStrike()) {
            strikeCount++;
        }
        if (ballStatus.isBall()) {
            ballCount++;
        }
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isAllStrike() {
        return strikeCount == BASEBALL_MAX_AMOUNT;
    }

    public String getHintMessage() {
        if (strikeCount == NO_HIT && ballCount == NO_HIT) {
            return BASEBALL_GAME_MESSAGE_NOTHING_KOR;
        }
        if (strikeCount == NO_HIT) {
            return ballCount + BASEBALL_GAME_MESSAGE_BALL_KOR;
        }
        if (ballCount == NO_HIT) {
            return strikeCount + BASEBALL_GAME_MESSAGE_STRIKE_KOR;
        }
        return ballCount + BASEBALL_GAME_MESSAGE_BALL_KOR + " " + strikeCount
            + BASEBALL_GAME_MESSAGE_STRIKE_KOR;
    }
}
