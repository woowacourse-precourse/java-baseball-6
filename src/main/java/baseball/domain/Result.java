package baseball.domain;

public class Result {
    private final int ball;
    private final int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    };

    @Override
    public String toString() {
        if(ball == 0 && strike == 0) return NumberBaseBall.NOTHING;

        String result = "";
        if(ball > 0) result = ball + NumberBaseBall.BALL + " ";
        if(strike > 0) result += strike + NumberBaseBall.STRIKE;

        return result.trim();
    }

    public boolean isCorrect() {
        return ball == 0 && strike == 3;
    }
}
