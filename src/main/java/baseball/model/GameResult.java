package baseball.model;


public class GameResult {
    private final int strikeCount;
    private final int ballCount;
    private static final String NOTHING = "낫싱";
    private static final int ZERO = 0;

    private GameResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static GameResult gameResultFactory(int strikeCount, int ballCount) {
        return new GameResult(strikeCount, ballCount);
    }

    public String resultString() {

        if (strikeCount == ZERO && ballCount == ZERO) {
            return NOTHING;
        }

        StringBuilder result = new StringBuilder();

        if (ballCount > ZERO) {
            result.append(ballCount);
            result.append("볼 ");
        }

        if (strikeCount > ZERO) {
            result.append(strikeCount);
            result.append("스트라이크");
        }

        return result.toString().trim();
    }
}
