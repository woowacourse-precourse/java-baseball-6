package baseball.domain;

public class Result {

    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        String output;
        if (strike != 0 && ball != 0) output = ball + "볼 " + strike + "스트라이크";
        else if(strike != 0) output = strike + "스트라이크";
        else if(ball != 0) output = ball + "볼";
        else output = "낫싱";

        return output;
    }
}
