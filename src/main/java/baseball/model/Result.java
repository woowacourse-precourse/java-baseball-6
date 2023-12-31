package baseball.model;

import static constants.BallDetails.BALL_SIZE;

public class Result {

    private final int strike;
    private final int ball;

    public Result(Ball answer, Ball player) {
        strike = checkStrike(answer, player);
        ball = checkBall(answer, player);
    }

    private int checkStrike(Ball answer, Ball player) {
        int strike = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (answer.isStrike(player, i)) {
                ++strike;
            }
        }
        return strike;
    }

    private int checkBall(Ball answer, Ball player) {
        int ball = 0;
        for (int i = 0; i < BALL_SIZE; i++) {
            if (answer.isBall(player, i)) {
                ++ball;
            }
        }
        return ball;
    }

    public boolean isStrikeOut() {
        return strike == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼").append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }
}
