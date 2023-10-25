package baseball;

public class RoundResult {
    private int strike;
    private int ball;

    public RoundResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(hasBall() ? (ball + "볼 ") : "");
        sb.append(hasStrike() ? (strike + "스트라이크 ") : "");

        return sb.toString();
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean isStrikeOut() {
        return strike == Constant.MAX_NUMBER_SIZE;
    }
}

