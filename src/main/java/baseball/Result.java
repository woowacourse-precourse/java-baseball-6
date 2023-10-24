package baseball;

public class Result {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    private final int ball;
    private final int strike;

    public Result(int ball, int strike){
        this.ball = ball;
        this.strike = strike;
    }
}
