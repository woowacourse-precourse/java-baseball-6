package baseball.domain;

import static baseball.global.GameMessage.BALL_COUNT_MESSAGE;
import static baseball.global.GameMessage.GAME_ENDED_MESSAGE;
import static baseball.global.GameMessage.NOTHING_COUNT_MESSAGE;
import static baseball.global.GameMessage.STRIKE_COUNT_MESSAGE;

public class ComparisonResult {

    private int ballCount;
    private int strikeCount;
    private String result;

    public ComparisonResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        configureResult();
    }

    private void isNothing() {
        if (this.strikeCount == 0 && this.ballCount == 0) {
            this.result = NOTHING_COUNT_MESSAGE.message;
        }
    }

    private boolean isThreeStrike() {
        return this.strikeCount == 3;
    }

    private void hasOnlyBall() {
        if (this.strikeCount == 0 && this.ballCount > 0) {
            this.result = "%d%s".formatted(ballCount, BALL_COUNT_MESSAGE.message);
        }
    }

    private void hasOnlyStrike() {
        if (this.strikeCount > 0 && this.ballCount == 0) {
            this.result = isThreeStrike() ? GAME_ENDED_MESSAGE.message
                    : "%d%s".formatted(strikeCount, STRIKE_COUNT_MESSAGE.message);
        }
    }

    private void hasBothBallAndStrike() {
        if (this.strikeCount > 0 && this.ballCount > 0) {
            this.result = "%d%s %d%s".formatted(
                    ballCount, BALL_COUNT_MESSAGE.message,
                    strikeCount, STRIKE_COUNT_MESSAGE.message);
        }
    }

    public void configureResult() {
        isNothing();
        hasOnlyBall();
        hasOnlyStrike();
        hasBothBallAndStrike();
    }

    public void printResult() {
        System.out.println(this.result);
    }

    public boolean checkGameEnded() {
        return this.result.equals(GAME_ENDED_MESSAGE.message);
    }
}
