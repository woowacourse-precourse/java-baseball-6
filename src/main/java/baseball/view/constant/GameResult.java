package baseball.view.constant;

public enum GameResult {
    NOTHING,
    STRIKE,
    BALL,
    OTHER,
    ;

    public static GameResult from(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return NOTHING;
        }
        if (strikeCount == 0) {
            return BALL;
        }
        if (ballCount == 0) {
            return STRIKE;
        }
        return OTHER;
    }

}
