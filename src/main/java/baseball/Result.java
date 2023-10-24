package baseball;

public class Result {

    private int ball;
    private int strike;

    private Result() {
        ball = 0;
        strike = 0;
    }

    public static Result getInstance() {
        return new Result();
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

}
