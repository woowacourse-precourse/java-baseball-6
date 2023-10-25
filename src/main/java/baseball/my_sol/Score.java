package baseball.my_sol;

public class Score {
    // 점수판
    private int strike = 0;
    private int ball = 0;

    public void updateScore(NumStatus ballStatus) {
        if (ballStatus.isStrike()) {
            ++strike;
        }
        if (ballStatus.isBall()) {
            ++ball;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
