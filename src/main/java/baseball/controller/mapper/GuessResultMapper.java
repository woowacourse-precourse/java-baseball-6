package baseball.controller.mapper;

import baseball.model.GuessResult;

public class GuessResultMapper {

    private static final int INITIAL_ZERO_COUNT = 0;
    private static final String NOTHING_RESULT = "낫싱";
    private static final String BALL_RESULT = "볼";
    private static final String STRIKE_RESULT = "스트라이크";

    public static String resultToString(final GuessResult result) {
        if (result.isNothing()) {
            return NOTHING_RESULT;
        }
        int ballCount = result.getBallCount();
        int strikeCount = result.getStrikeCount();

        if (ballCount == INITIAL_ZERO_COUNT) {
            return strikeCount + STRIKE_RESULT;
        }

        if (strikeCount == INITIAL_ZERO_COUNT) {
            return ballCount + BALL_RESULT;
        }

        return ballCount + BALL_RESULT + " " + strikeCount + STRIKE_RESULT;
    }
}
