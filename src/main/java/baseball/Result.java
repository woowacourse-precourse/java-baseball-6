package baseball;

public class Result {
    private static final int ZERO_COUNT = 0;
    private static final int WIN_STRIKE_COUNT = 3;
    private static final String NOTHING_RESULT_MESSAGE = "낫싱";
    private static final String STRIKE_RESULT_MESSAGE = "스트라이크";
    private static final String BALL_RESULT_MESSAGE = "볼";
    private static final String SPACE = " ";

    private final int strikeCount;
    private final int ballCount;

    public Result(Baseballs baseballs, Baseballs compareBaseballs) {
        this.strikeCount = baseballs.countStrike(compareBaseballs);
        this.ballCount = baseballs.countBall(compareBaseballs);
    }

    public String getResult() {
        if (strikeCount == ZERO_COUNT && ballCount == ZERO_COUNT) {
            return NOTHING_RESULT_MESSAGE;
        }
        if (strikeCount == ZERO_COUNT) {
            return ballCount + BALL_RESULT_MESSAGE;
        }
        if (ballCount == ZERO_COUNT) {
            return strikeCount + STRIKE_RESULT_MESSAGE;
        }
        return ballCount + BALL_RESULT_MESSAGE + SPACE + strikeCount + STRIKE_RESULT_MESSAGE;
    }

    public boolean isClear() {
        if (this.strikeCount == WIN_STRIKE_COUNT) return true;
        return false;
    }

}
