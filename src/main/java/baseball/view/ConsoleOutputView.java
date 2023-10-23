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
        if (isNothing(ballCount, strikeCount)) {
            return NOTHING;
        }
        if (isOnlyBall(ballCount, strikeCount)) {
            return ballCount + BALL;
        }
        if (isOnlyStrike(ballCount, strikeCount)) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }

    private boolean isNothing(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount == ZERO;
    }

    private boolean isOnlyBall(final int ballCount, final int strikeCount) {
        return ballCount != ZERO && strikeCount == ZERO;
    }

    private boolean isOnlyStrike(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount != ZERO;
    }
}
