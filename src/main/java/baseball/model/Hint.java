package baseball.model;

public class Hint {

    private int ball;
    private int strike;

    public Hint(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isStrike(int size) {
        return strike == size ? true : false;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball > 0) {
            buffer.append(ball + "볼 ");
        }

        if (strike > 0) {
            buffer.append(strike + "스트라이크");
        }
        return buffer.toString().trim();
    }
}
