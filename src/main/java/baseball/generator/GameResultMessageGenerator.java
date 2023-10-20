package baseball.generator;

import baseball.GameResult;

public class GameResultMessageGenerator {


    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static String createGameResultMessage(final GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING_MESSAGE;
        }
        if (gameResult.isZeroStrike()) {
            return gameResult.getBall() + BALL_MESSAGE;
        }
        if (gameResult.isZeroBall()) {
            return gameResult.getStrike() + STRIKE_MESSAGE;
        }
        return gameResult.getBall() + BALL_MESSAGE + " " + gameResult.getStrike() + STRIKE_MESSAGE;
    }
}
