package baseball.controller.mapper;

public class ResultMapper {

    private static final int NO_STRIKE = 0;
    private static final int NO_BALL = 0;
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String BLANK = " ";

    private ResultMapper() {
    }

    public static String mapToStringWith(final int ballCount, final int strikeCount) {
        if (isNothing(ballCount, strikeCount)) {
            return NOTHING;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }

    private static boolean isNothing(final int ballCount, final int strikeCount) {
        return ballCount == NO_BALL && strikeCount == NO_STRIKE;
    }
}
