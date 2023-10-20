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
        if (ball == 0 && strike == 0) return "낫싱";
        String str = "";
        if (ball != 0) {
            str += (ball + "볼");
            if (strike != 0) str += " ";
        }
        if (strike != 0) str += (strike + "스트라이크");
        return str;
    }
}
