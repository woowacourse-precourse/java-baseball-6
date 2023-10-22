package baseball.util;

import baseball.domain.GameResult;

public class StringUtil {

    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public String makeResultMessage(GameResult gameResult) {
        StringBuilder sb = new StringBuilder();
        int ballCount = gameResult.getBallCount();
        int strikeCount = gameResult.getStrikeCount();
        if (ballCount != 0) {
            sb.append(ballCount).append(BALL);
        }
        if (strikeCount != 0) {
            sb.append(strikeCount).append(STRIKE);
        }
        if (sb.isEmpty()) {
            sb.append(NOTHING);
        }
        return sb.toString();
    }
}
