package baseball.view;

public class ConsoleOutputView implements OutputView {

    private static final int ZERO = 0;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BLANK = " ";
    private static final String EMPTY = "";

    @Override
    public void print(final String message) {
        System.out.println(message);
    }

    public void printGameResult(final int ballCount, final int strikeCount) {
        String result = makeBallResult(ballCount) + BLANK + makeStrikeResult(strikeCount);
        System.out.println(result);
    }

    private String makeBallResult(final int ballCount) {
        if (isZero(ballCount)) {
            return EMPTY;
        }
        return ballCount + BALL;
    }

    private String makeStrikeResult(final int strikeCount) {
        if (isZero(strikeCount)) {
            return NOTHING;
        }
        return strikeCount + STRIKE;
    }

    private boolean isZero(final int count) {
        return count == ZERO;
    }
}
