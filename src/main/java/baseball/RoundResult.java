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
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크 ");
        }

        return sb.toString();
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isStrikeOut() {
        return strike == Constant.MAX_NUMBER_SIZE;
    }
}

