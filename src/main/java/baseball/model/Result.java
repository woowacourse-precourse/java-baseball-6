package baseball.model;

public class Result {
    private final int strike;
    private final int ball;
    private boolean isEnd;
    private String result = "";

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        if (strike==3) isEnd = true;
    }

    public String getResult() {
        if (strike == 0 && ball == 0) {
            result = "낫싱";
        }
        if (ball != 0) {
            result = result + ball + "볼 ";
        }
        if (strike != 0) {
            result = result + strike + "스트라이크";
        }

        return result;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
