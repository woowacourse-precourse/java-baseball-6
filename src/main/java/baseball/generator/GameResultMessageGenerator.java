package baseball.generator;

import baseball.dto.GameResult;

public class GameResultMessageGenerator {

    private static final String STRIKE_MESSAGE = " %d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String EMPTY_MESSAGE = "";

    public static String createGameResultMessage(final GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING_MESSAGE;
        }
        return createBallMessage(gameResult).trim();
    }

    private static String createBallMessage(final GameResult gameResult) {
        if (gameResult.isZeroBall()) {
            return createStrikeMessage(gameResult, EMPTY_MESSAGE);
        }
        return createStrikeMessage(gameResult, String.format(BALL_MESSAGE, gameResult.ball()));
    }

    private static String createStrikeMessage(final GameResult gameResult, final String ballMessage) {
        if (gameResult.isZeroStrike()) {
            return ballMessage;
        }
        return String.format(ballMessage + STRIKE_MESSAGE, gameResult.strike());
    }
}
