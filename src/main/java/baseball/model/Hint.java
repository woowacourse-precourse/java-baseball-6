package baseball.model;

public class Hint {
    int strike = 0;
    int ball = 0;

    public Hint() {
    }

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void getStrikeAndBallCount(Balls computer, Balls player) {
        for (Ball playerBall : player.getBalls()) {
            if (computer.isStrike(playerBall)) {
                strike++;
            }
        }
        for (Ball playerBall : player.getBalls()) {
            if (computer.isBall(playerBall)) {
                ball++;
            }
        }
    }

    public boolean isOnlyStrike() {
        return strike != 0 && ball == 0;
    }

    public boolean isOnlyBall() {
        return strike == 0 && ball != 0;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isGameFinish() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
