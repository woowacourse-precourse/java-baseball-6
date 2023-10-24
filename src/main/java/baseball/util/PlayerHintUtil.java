package baseball.util;

import java.util.List;

public class PlayerHintUtil {

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOT_THING = "낫싱";
    private static final String SPACING = " ";
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    private static String playerHint;

    public void ballAndStrikeResultHint(List<Integer> ballAndStrikeCount){
        int ballCount = ballAndStrikeCount.get(BALL_INDEX);
        int strikeCount = ballAndStrikeCount.get(STRIKE_INDEX);

        if (ballCount == 0 && strikeCount == 0) {
            this.playerHint = NOT_THING;
            return;
        }
        if (ballCount == 0 && strikeCount != 0) {
            this.playerHint = strikeCount + STRIKE;
            return;
        }
        if (ballCount != 0 && strikeCount == 0) {
            this.playerHint = ballCount + BALL;
            return;
        }

        this.playerHint = ballCount + BALL + SPACING + strikeCount + STRIKE;
    }

    public static String getPlayerHint() {
        return playerHint;
    }

}
