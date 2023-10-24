package baseball.model;

import baseball.model.ball.BallStatus;

public class SwingResult {
    int strikeCount = 0;
    int ballCount = 0;

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
        return strikeCount == 3;
    }

    public String getResultMessage() {
        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        }
        if (strikeCount == 0) {
            return ballCount + "볼";
        }
        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        }
        return ballCount + "볼" + " " + strikeCount + "스트라이크";
    }
}
