package baseball.domain;

public class BaseballGameResult {
    private int strikeCount;
    private int ballCount;
    private static final String BLANK = " ";

    private BaseballGameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public boolean isFinish(int count) {
        if (this.strikeCount == count) {
            return true;
        }
        return false;
    }

    public String getResult() {
        if (strikeCount > 0 && ballCount > 0) {
            return ballCount + NumberStatus.BALL.getValue() + BLANK + strikeCount + NumberStatus.STRIKE.getValue();
        }
        if (strikeCount > 0 && ballCount == 0) {
            return strikeCount + NumberStatus.STRIKE.getValue();
        }
        if (strikeCount == 0 && ballCount > 0) {
            return ballCount + NumberStatus.BALL.getValue();
        }
        return NumberStatus.NOTHING.getValue();
    }
    public static BaseballGameResult from(int strikeCount, int ballCount) {
        return new BaseballGameResult(strikeCount, ballCount);
    }
}
