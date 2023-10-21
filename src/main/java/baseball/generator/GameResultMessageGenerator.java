package baseball.generator;

import baseball.GameResult;

public class GameResultMessageGenerator {

    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String COMBINED_MESSAGE = "%d볼 %d스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static String createGameResultMessage(final GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING_MESSAGE;
        }
        if (gameResult.isZeroStrike()) {
            return String.format(BALL_MESSAGE, gameResult.getBall());
        }
        if (gameResult.isZeroBall()) {
            return String.format(STRIKE_MESSAGE, gameResult.getStrike());
        }
        return String.format(COMBINED_MESSAGE, gameResult.getBall(), gameResult.getStrike());
    }
}
