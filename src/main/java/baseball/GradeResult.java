package baseball;

public class GradeResult {
    private int ball;
    private int strike;

    private final int ANSWER_STRIKE_NUM = 3;

    public GradeResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isAnswer() {
        if (strike == ANSWER_STRIKE_NUM) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
