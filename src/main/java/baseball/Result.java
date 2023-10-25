package baseball;

public class Result {
    private final int ball;
    private final int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public String print() {
        return ball == 0 ?
                (strike == 0 ? "낫싱" : strike + "스트라이크") :
                (strike == 0 ? ball + "볼" : ball + "볼 " + strike + "스트라이크");
    }

    public int getStrike() {
        return strike;
    }
}
