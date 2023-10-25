package baseball.game;

public class CompareResult {
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BLANK = " ";

    private static final int END_STRIKE_COUNT = 3;
    private final int strikeCount;
    private final int ballCount;

    public CompareResult(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String getResultMessage() {
        StringBuilder resultMessage = new StringBuilder();
        addBallMessage(resultMessage);
        addStrikeMessage(resultMessage);
        addNothingMessage(resultMessage);

        return resultMessage.toString();
    }

    private void addBallMessage(StringBuilder resultMessage) {
        if (ballCount > 0) {
            resultMessage.append(this.ballCount).append(BALL_MESSAGE);
        }
    }

    private void addStrikeMessage(StringBuilder resultMessage) {
        if (!resultMessage.isEmpty()) {
            resultMessage.append(BLANK);
        }

        if (strikeCount > 0) {
            resultMessage.append(this.strikeCount).append(STRIKE_MESSAGE);
        }
    }

    private void addNothingMessage(StringBuilder resultMessage) {
        if (resultMessage.isEmpty()) {
            resultMessage.append(NOTHING_MESSAGE);
        }
    }

    public boolean isAnswer() {
        return strikeCount == END_STRIKE_COUNT;
    }
}
