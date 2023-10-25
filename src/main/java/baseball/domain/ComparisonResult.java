package baseball.domain;

import static baseball.global.common.GameMessage.BALL_COUNT_MESSAGE;
import static baseball.global.common.GameMessage.GAME_ENDED_MESSAGE;
import static baseball.global.common.GameMessage.NOTHING_COUNT_MESSAGE;
import static baseball.global.common.GameMessage.STRIKE_COUNT_MESSAGE;

public class ComparisonResult {

    private final int ballCount;
    private final int strikeCount;
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
            this.result = "%d%s".formatted(strikeCount, STRIKE_COUNT_MESSAGE.message);
        }
    }

    private void hasBothBallAndStrike() {
        if (this.strikeCount > 0 && this.ballCount > 0) {
            this.result = "%d%s %d%s".formatted(
                    ballCount, BALL_COUNT_MESSAGE.message,
                    strikeCount, STRIKE_COUNT_MESSAGE.message);
        }
    }

    private void configureResult() {
        isNothing();
        hasOnlyBall();
        hasOnlyStrike();
        hasBothBallAndStrike();
    }

    private void printGameEndedMessage() {
        if (isThreeStrike()) {
            System.out.print(GAME_ENDED_MESSAGE.message);
        }
    }

    public void printResult() {
        System.out.println(this.result);
        printGameEndedMessage();
    }

    public boolean checkGameEnded() {
        return isThreeStrike();
    }
}
