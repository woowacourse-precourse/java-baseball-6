package baseball.service;

import baseball.domain.BallCounter;
import baseball.domain.BallStatus;
import baseball.domain.Balls;

import java.util.List;

public class Referee {

    private static final int MAX_BALL_SIZE = 3;
    private static final int ZERO = 0;

    private BallStatus checkBallStatus(Balls computer, Balls player) {
        if (computer.getLocation() == player.getLocation() && computer.getNumber() == player.getNumber()) {
            return BallStatus.STRIKE;
        }
        if (computer.getLocation() != player.getLocation() && computer.getNumber() == player.getNumber()) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public BallCounter judgeGame(List<Balls> computerBalls, List<Balls> playerBalls) {
        BallCounter ballCounter = new BallCounter(ZERO, ZERO);

        for (Balls computerBall : computerBalls) {
            checkPlayerBalls(computerBall, playerBalls, ballCounter);
        }
        return ballCounter;
    }

    private void checkPlayerBalls(Balls computerBall, List<Balls> playerBalls, BallCounter ballCounter) {
        for (Balls playerBall : playerBalls) {
            BallStatus status = checkBallStatus(computerBall, playerBall);
            updateCounterByStatus(status, ballCounter);
        }
    }

    private void updateCounterByStatus(BallStatus ballStatus, BallCounter ballCounter) {
        if (ballStatus.equals(BallStatus.STRIKE)) {
            ballCounter.increaseStrikeCount();
        }
        if (ballStatus.equals(BallStatus.BALL)) {
            ballCounter.increaseBallCount();
        }
    }

    public boolean isEndGameCondition(BallCounter ballCounter) {
        return ballCounter.getStrikeCount() == MAX_BALL_SIZE;
    }
}
