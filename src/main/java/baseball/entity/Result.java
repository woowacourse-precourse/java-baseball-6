package baseball.entity;

public class Result {

    public boolean isAnswer;
    public int strike;
    public int ball;

    public Result(boolean isAnswer, int strike, int ball) {
        this.isAnswer = isAnswer;
        this.strike = strike;
        this.ball = ball;
    }
}
