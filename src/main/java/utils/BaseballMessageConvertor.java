package utils;

import model.referee.GameScoreboard;

public class BaseballMessageConvertor {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public static String generateScoreMessage(GameScoreboard gameScoreboard) {
        StringBuilder builder = new StringBuilder();
        int strike = gameScoreboard.getStrike();
        int ball = gameScoreboard.getBall();

        if (ball > 0) {
            builder.append(ball).append(BALL);
            if (strike > 0) {
                builder.append(" ");
            }
        }
        if (strike > 0) {
            builder.append(strike).append(STRIKE);
        }
        if (gameScoreboard.isNothing()) {
            builder.append(NOTHING);
        }
        return builder.toString();
    }
}
