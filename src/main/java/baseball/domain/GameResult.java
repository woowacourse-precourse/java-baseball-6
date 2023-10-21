package baseball.domain;

import static baseball.constant.GameConstant.BALL;
import static baseball.constant.GameConstant.NOTHING;
import static baseball.constant.GameConstant.STRIKE;
import static baseball.constant.GameConstant.THREE_STRIKE;

public class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String result() {
        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + BALL + " " + strikeCount + STRIKE;
        } else if (ballCount != 0) {
            return ballCount + BALL;
        } else if (strikeCount != 0) {
            return strikeCount + STRIKE;
        }
        return NOTHING;
    }

    public boolean gameEnd() {
        return !(strikeCount == THREE_STRIKE);
    }


}
