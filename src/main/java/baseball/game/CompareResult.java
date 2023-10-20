package baseball.game;

public class CompareResult {
    private final int ball;
    private final int strike;

    protected CompareResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
        if (strike > 0) {
            sb.append(ball > 0 ? " " : "").append(strike).append("스트라이크");
        }

        return sb.toString();
    }
}
