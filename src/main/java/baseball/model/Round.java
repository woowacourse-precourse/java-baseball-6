package baseball.model;

public class Round {
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String NOTHING_STRING = "낫싱";
    private static final String BLANK_STRING = " ";
    private final int ballCount;
    private final int strikeCount;

    public Round(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String calculateResult() {
        StringBuilder result = new StringBuilder();

        if (ballCount > 0) {
            result.append(ballCount);
            result.append(BALL_STRING);
        }
        if (ballCount > 0 && strikeCount > 0) {
            result.append(BLANK_STRING);
        }
        if (strikeCount > 0) {
            result.append(strikeCount);
            result.append(STRIKE_STRING);
        }
        if (result.isEmpty()) {
            result.append(NOTHING_STRING);
        }

        return result.toString().trim();
    }
}
