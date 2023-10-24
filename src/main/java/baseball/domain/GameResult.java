package baseball.domain;

import static baseball.constant.GameConstant.ALL_STRIKE;
import static baseball.constant.GameConstant.BALL;
import static baseball.constant.GameConstant.NOTHING;
import static baseball.constant.GameConstant.STRIKE;

/**
 * 게임 결과 도메인
 */

public class GameResult {
    private int ballCount = 0;
    private int strikeCount = 0;

    public void gameResultInit(int ballCount, int strikeCount) {
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
        return !(strikeCount == ALL_STRIKE);
    }


}
