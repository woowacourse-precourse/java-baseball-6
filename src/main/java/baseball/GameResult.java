package baseball;

public class GameResult {
    private int strike;
    private int ball;

    public void checkBallIndex(int destIndex, int targetIndex) {
        if (destIndex == targetIndex) {
            strike++;
            return;
        }
        if (targetIndex >= 0) {
            ball++;
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        if (strike + ball == 0) {
            return BallStatus.NOTING.toString();
        }

        String result = "";
        if (ball > 0) {
            result = ball + BallStatus.BALL.toString() + " ";
        }
        if (strike > 0) {
            result += strike + BallStatus.STRIKE.toString();
        }

        return result.trim();
    }
}
