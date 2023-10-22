package baseball.controller.mapper;

public class ResultMapper {

    private static final int ZERO = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";

    public static String resultToString(final int ballCount, final int strikeCount) {
        if (isOut(ballCount, strikeCount)) {
            return NOTHING;
        }

        return buildStatus(ballCount, strikeCount);
    }

    private static boolean isOut(final int ballCount, final int strikeCount) {
        return ballCount == ZERO && strikeCount == ZERO;
    }

    private static String buildStatus(final int ballCount, final int strikeCount) {
        StringBuilder status = new StringBuilder();
        appendIfNonZero(status, ballCount, BALL);
        appendIfNonZero(status, strikeCount, STRIKE);

        return status.toString();
    }

    private static void appendIfNonZero(final StringBuilder status, final int count, final String symbol) {
        if (hasCount(count)) {
            status.append(count).append(symbol);
        }
    }

    private static boolean hasCount(final int count) {
        return count != ZERO;
    }
}
