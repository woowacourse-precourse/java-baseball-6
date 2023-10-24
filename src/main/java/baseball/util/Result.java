package baseball.util;

public class Result {
    private Status strike;
    private Status ball;

    public Result(Status ball, Status strike) {
        this.strike = strike;
        this.ball = ball;
    }

    public void checkValidate() {
    }

    public boolean checkNothing() {
        return false;
    }

    public void printResult() {
    }
}
