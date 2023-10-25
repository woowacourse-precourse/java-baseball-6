package baseball.games.numberbaseball.domain;

public class BallCount {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private final int ballCount;
    private final int strikeCount;

    public BallCount(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    public String createBallCountMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        if (ballCount == 0) {
            return strikeCount + STRIKE;
        }
        if (strikeCount == 0) {
            return ballCount + BALL;
        }
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }
}
