package baseball.model;

public class GameResult {
    private int ball;
    private int strike;

    public GameResult(int ball, int strike) {
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
        if (ball == 0 && strike == 0) return "낫싱\n";
        StringBuilder str = new StringBuilder();
        if (ball != 0) {
            str.append(ball).append("볼");
        }
        if (strike != 0) {
            if (ball != 0) str.append(" ");
            str.append(strike).append("스트라이크");
        }
        str.append("\n");
        return str.toString();
    }
}
