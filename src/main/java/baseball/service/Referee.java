package baseball.service;

import baseball.domain.BallCounter;
import baseball.domain.BallStatus;
import baseball.domain.Balls;

import java.util.List;

public class Referee {

    private static final int MAX_BALL_SIZE = 3;

    public BallStatus checkBallStatus(Balls computer, Balls player) {
        if (computer.getLocation() == player.getLocation() && computer.getNumber() == player.getNumber()) {
            return BallStatus.STRIKE;
        }
        if (computer.getLocation() != player.getLocation() && computer.getNumber() == player.getNumber()) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public BallCounter judgeGame(List<Balls> computerBalls, List<Balls> playerBalls) {
        BallCounter ballCounter = new BallCounter(0, 0);

        for (Balls computerBall : computerBalls) {
            ballCounter = checkPlayerBalls(computerBall, playerBalls, ballCounter);
        }

        return ballCounter;
    }

    private BallCounter checkPlayerBalls(Balls computerBall, List<Balls> playerBalls, BallCounter ballCounter) {
        for (Balls playerBall : playerBalls) {
            BallStatus status = checkBallStatus(computerBall, playerBall);
            ballCounter = updateCounterByStatus(status, ballCounter);
        }
        return ballCounter;
    }

    private BallCounter updateCounterByStatus(BallStatus ballStatus, BallCounter ballCounter) {
        if (ballStatus.equals(BallStatus.STRIKE)) {
            ballCounter.increaseStrikeCount();
        }
        if (ballStatus.equals(BallStatus.BALL)) {
            ballCounter.increaseBallCount();
        }
        return ballCounter;
    }

    public boolean isEndGameCondition(BallCounter ballCounter) {
        return ballCounter.getStrikeCount() == MAX_BALL_SIZE;
    }
}
