package game;

import client.Ball;
import constants.NumberConstants;

public class Referee {

    private final Ball computerBall;
    private final Ball playerBall;

    public Referee(Ball computerBall, Ball playerBall) {
        this.computerBall = computerBall;
        this.playerBall = playerBall;
    }

    public BallCounts judge() {
        int ball = countBall();
        int strike = countStrike();
        return new BallCounts(ball, strike);
    }

    private int countBall() {
        int count = 0;
        for (int i = 0; i < NumberConstants.MAX_BALL_SIZE; i++) {
            count = increaseIfBall(i, count);
        }
        return count;
    }

    private int increaseIfBall(int i, int count) {
        if (isBall(i)) {
            count += 1;
        }
        return count;
    }

    private boolean isBall(int i) {
        char number = playerBall.ballAt(i);
        return computerBall.ballAt(i) != number && computerBall.contains(number);
    }

    private int countStrike() {
        int count = 0;
        for (int i = 0; i < NumberConstants.MAX_BALL_SIZE; i++) {
            count = increaseIfStrike(i, count);
        }
        return count;
    }

    private int increaseIfStrike(int i, int count) {
        if (isStrike(i)) {
            count += 1;
        }
        return count;
    }

    private boolean isStrike(int i) {
        return computerBall.ballAt(i) == playerBall.ballAt(i);
    }

}
