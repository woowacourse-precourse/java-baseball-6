package baseball.view;

public class ConsoleOutputView implements OutputView {

    private static final int ZERO = 0;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";

    @Override
    public void print(final String message) {
        System.out.print(message);
    }

    public void printGameResult(final int ballCount, final int strikeCount) {
        String result = makeResult(ballCount, strikeCount);
        print(result + NEW_LINE);
    }

    private String makeResult(final int ballCount, final int strikeCount) {
        StringBuilder stringBuilder = new StringBuilder();

        appendIfOnlyBall(ballCount, strikeCount, stringBuilder);
        appendIfOnlyStrike(ballCount, strikeCount, stringBuilder);
        appendIfNothing(ballCount, strikeCount, stringBuilder);

        if (isEmptyOf(stringBuilder)) {
            appendWithBallsAndStrikes(ballCount, strikeCount, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void appendIfOnlyBall(final int ballCount, final int strikeCount, final StringBuilder stringBuilder) {
        if (isOnlyBall(ballCount, strikeCount)) {
            String result = ballCount + BALL;
            stringBuilder.append(result);
        }
    }

    private boolean isOnlyBall(final int ballCount, final int strikeCount) {
        return ballCount != ZERO && strikeCount == ZERO;
    }

    private void appendIfOnlyStrike(final int ballCount, final int strikeCount, final StringBuilder stringBuilder) {
        if (isOnlyStrike(ballCount, strikeCount)) {
            String result = strikeCount + STRIKE;
            stringBuilder.append(result);
        }
    }

    private boolean isOnlyStrike(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount != ZERO;
    }

    private void appendIfNothing(final int ballCount, final int strikeCount, final StringBuilder stringBuilder) {
        if (isNothing(ballCount, strikeCount)) {
            stringBuilder.append(NOTHING);
        }
    }

    private boolean isNothing(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount == ZERO;
    }

    private boolean isEmptyOf(final StringBuilder stringBuilder) {
        return stringBuilder.length() == ZERO;
    }

    private void appendWithBallsAndStrikes(final int ballCount, final int strikeCount,
                                           final StringBuilder stringBuilder) {
        String result = ballCount + BALL + BLANK + strikeCount + STRIKE;
        stringBuilder.append(result);
    }
}
