package baseball.util;

import baseball.GameResult;

public class Util {
    public static String appendGameResult(long ballTotal, long strikeTotal) {
        StringBuilder gameResultBuilder = new StringBuilder();

        if (ballTotal == 0 && strikeTotal == 0) {
            gameResultBuilder.append(GameResult.NOTHING.getResultMessage());
            return gameResultBuilder.toString();
        }

        if (ballTotal > 0) {
            gameResultBuilder.append(ballTotal + GameResult.BALL.getResultMessage() + " ");
        }

        if (strikeTotal > 0) {
            gameResultBuilder.append(strikeTotal + GameResult.STRIKE.getResultMessage());
        }

        return gameResultBuilder.toString();
    }
}
