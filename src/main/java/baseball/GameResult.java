package baseball;

public class GameResult {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static final String SPACE = " ";

    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        if (hasBall() && hasStrike()) {
            return ball + BALL + SPACE + strike + STRIKE;
        } else if (hasStrike()) {
            return strike + STRIKE;
        } else if (hasBall()) {
            return ball + BALL;
        }
        return NOTHING;
    }

    private boolean hasStrike() {
        return strike > 0;
    }

    private boolean hasBall() {
        return ball > 0;
    }
}
