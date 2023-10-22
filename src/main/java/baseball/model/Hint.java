package baseball.model;

public class Hint {
    int strike = 0;
    int ball = 0;

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
}
