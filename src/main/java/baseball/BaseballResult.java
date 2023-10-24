package baseball;

public class BaseballResult implements GameResult {
    private int strike = 0;
    private int ball = 0;

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public boolean isCorrect() {
        return 3 == strike;
    }

    @Override
    public String toHangul() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball > 0 && strike > 0) {
            // ball and strike
            return String.format("%d볼 %d스트라이크", ball, strike);
        } else if (ball > 0) {
            // only ball
            return String.format("%d볼", ball);
        } else {
            // only strike
            return String.format("%d스트라이크", strike);
        }

    }

}
