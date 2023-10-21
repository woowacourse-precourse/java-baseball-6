package baseball.domain;

import java.util.List;

public class Referee {

    List<BallStatus> BallStatuses;
    int strikeNum = 0;
    int ballNum = 0;

    public Referee(List<BallStatus> result) {
        this.BallStatuses = result;
        judge();
    }

    private void judge() {
        for (BallStatus ballStatus : BallStatuses) {
            if (ballStatus == BallStatus.STRIKE) {
                strikeNum ++;
            }
            if (ballStatus == BallStatus.BALL) {
                ballNum ++;
            }
        }
    }

    public int getStrikeNum() {
        return strikeNum;
    }

    public int getBallNum() {
        return ballNum;
    }
}
