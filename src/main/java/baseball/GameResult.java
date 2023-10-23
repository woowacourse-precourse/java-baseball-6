package baseball;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isNothing()) {
            return "낫싱";
        }

        if (ball != 0) {
            sb.append(ball + "볼 ");
        }
        if (strike != 0) {
            sb.append(strike + "스트라이크 ");
        }

        return sb.toString();
    }
}

