package baseball.service;

import baseball.model.Ball;
import baseball.model.BallGenerator;

public class BaseballService {

    private Ball answerBall;

    public void init() {
        answerBall = BallGenerator.generateBall();
    }

    public int getStrike(Ball playerBall) {
        return answerBall.checkStrike(playerBall);
    }

    public int getBall(Ball playerBall) {
        return answerBall.checkBall(playerBall);
    }

    public boolean strikeOut(Ball playerBall) {
        return answerBall.checkStrike(playerBall) == 3;
    }

}
