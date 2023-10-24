package baseball.model;

import baseball.model.ball.BallStatus;

public class SwingResult {
    int strikeCount = 0 ;
    int ballCount = 0 ;
    public void report(BallStatus ballStatus) {
        if(ballStatus.isNothing()) return;
        if(ballStatus.isStrike()) strikeCount++;
        if(ballStatus.isBall()) ballCount++;
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
}
