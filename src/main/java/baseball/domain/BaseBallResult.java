package baseball.domain;

import static baseball.domain.BaseBallResultType.*;

record BaseBallResult(int ballCount, int strikeCount) {

    BaseBallResultType getResultType() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        if (strikeCount == 3) {
            return PERFECT_STRIKE;
        }
        if (ballCount > 0 && strikeCount > 0) {
            return BALL_STRIKE;
        }
        if (ballCount > 0) {
            return BALL;
        }
        if (strikeCount > 0) {
            return STRIKE;
        }
        throw new IllegalStateException("발생하지 않는 경우");
    }
}
