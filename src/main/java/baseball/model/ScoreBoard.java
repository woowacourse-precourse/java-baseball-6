package baseball.model;

import baseball.BallStatus;
import java.util.List;

public class ScoreBoard {

    private final List<String> scoreBoardList;

    public ScoreBoard(List<String> scoreBoardList) {
        this.scoreBoardList = scoreBoardList;
    }

    public int countStrike() {
        return (int) scoreBoardList.stream()
                .filter(ballStatus -> ballStatus.equals(BallStatus.STRIKE.getBallStatus()))
                .count();
    }

    public int countBall() {
        return (int) scoreBoardList.stream()
                .filter(ballStatus -> ballStatus.equals(BallStatus.BALL.getBallStatus()))
                .count();
    }

    public boolean isNothing() {
        if ((int) scoreBoardList.stream()
                .filter(ballStatus -> ballStatus.equals(BallStatus.NOTHING.getBallStatus()))
                .count() == scoreBoardList.size()) {
            return true;
        }
        return false;
    }

    public boolean isThreeStrike() {
        if (countStrike() == scoreBoardList.size()) {
            return true;
        }
        return false;
    }
}
