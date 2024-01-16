package baseball.domain;

import java.util.List;

/**
 * Inning : 한 이닝의 결과를 계산하고 판정하는 역할. 의존성: BaseBallMount, Sign
 */
public class Inning {
    public static final int ZERO = 0;
    public static final int FULL_STRIKE = 3;

    private int strikeCount = 0;
    private int ballCount = 0;


    public String referee(BaseBallMount computerMount, BaseBallMount playerMount) {
        calculateResult(computerMount, playerMount);
        return judgeMountResult();
    }


    public boolean isAllStrike() {
        return strikeCount == FULL_STRIKE && ballCount == ZERO;
    }

    private void calculateResult(BaseBallMount computerMount, BaseBallMount playerMount) {
        List<BaseBall> computerBaseBalls = computerMount.getBaseBalls();
        List<BaseBall> playerBaseBalls = playerMount.getBaseBalls();

        // TODO: 이건 BaseBallMount의 책임.
        for (int i = 0; i < playerBaseBalls.size(); i++) {
            if (computerBaseBalls.get(i).equals(playerBaseBalls.get(i))) {
                this.strikeCount++;
            } else if (computerBaseBalls.contains(playerBaseBalls.get(i))) {
                this.ballCount++;
            }
        }
    }

    private String judgeMountResult() {
        if (this.strikeCount == ZERO && this.ballCount == ZERO) {
            return Sign.NOTHING.getValue();
        }
        if (this.strikeCount == ZERO) {
            return this.ballCount + Sign.BALL.getValue();
        } else if (this.ballCount == ZERO) {
            return this.strikeCount + Sign.STRIKE.getValue();
        } else {
            return this.ballCount + Sign.BALL.getValue() + " " + this.strikeCount + Sign.STRIKE.getValue();
        }
    }

}
