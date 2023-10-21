package baseball.controller.mapper;

public class ResultMapper {

    private static final int DEFAULT_COUNT = 0;
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";

    public static String resultToString(final int ballCount, final int strikeCount) {
        if (isOut(ballCount, strikeCount)) {
            return NOTHING;
        }

        return buildStatus(ballCount, strikeCount);
    }

    private static String buildStatus(final int ballCount, final int strikeCount) {
        StringBuilder status = new StringBuilder();
        appendBallCount(status, ballCount);
        appendStrikeCount(status, strikeCount);
        return status.toString();
    }

    private static void appendBallCount(final StringBuilder status, final int ballCount) {
        if (hasBallCount(ballCount)) {
            status.append(ballCount).append(BALL);
        }
    }

    private static void appendStrikeCount(final StringBuilder status, final int strikeCount) {
        if (hasStrikeCount(strikeCount)) {
            status.append(strikeCount).append(STRIKE);
        }
    }

    private static boolean hasBallCount(final int ballCount) {
        return ballCount != DEFAULT_COUNT;
    }

    private static boolean hasStrikeCount(final int strikeCount) {
        return strikeCount != DEFAULT_COUNT;
    }

    private static boolean isOut(final int ballCount, final int strikeCount) {
        return ballCount == DEFAULT_COUNT && strikeCount == DEFAULT_COUNT;
    }
}
