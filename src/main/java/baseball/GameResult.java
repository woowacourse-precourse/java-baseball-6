package baseball;

public class GameResult {

    private static final String BALL_TEXT = "볼";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTING_TEXT = "낫싱";
    private static final String SPACE = " ";

    private Integer ballCount;
    private Integer strikeCount;

    public GameResult(Integer ballCount, Integer strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public Boolean isAnswer() {
        return strikeCount == Computer.NUMBER_DIGIT;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTING_TEXT;
        }

        StringBuilder sb = new StringBuilder(10);

        if (ballCount > 0) {
            sb.append(ballCount).append(BALL_TEXT).append(SPACE);
        }

        if (strikeCount > 0) {
            sb.append(strikeCount).append(STRIKE_TEXT);
        }

        return sb.toString().trim();
    }
}
