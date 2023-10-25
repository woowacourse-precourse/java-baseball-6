package baseball.game;

import baseball.domain.BaseBall;
import baseball.domain.BaseBallMount;
import java.util.List;
import java.util.Objects;

public class MountResult {
    public static final int ZERO = 0;
    public static final int FULL_STRIKE = 3;
    public static final String NOTHING_SIGN = "낫싱";
    public static final String STRIKE_SIGN = "스트라이크";
    public static final String BALL_SIGN = "볼";


    private int strikeCount = 0;
    private int ballCount = 0;

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNotAllStrike() {
        return !(strikeCount == FULL_STRIKE && ballCount == ZERO);
    }

    public String referee(BaseBallMount computerMount, BaseBallMount playerMount) {
        calculateResult(computerMount, playerMount);
        return judgeMountResult();
    }

    public void calculateResult(BaseBallMount computerMount, BaseBallMount playerMount) {
        List<BaseBall> computerBaseBalls = computerMount.getBaseBalls();
        List<BaseBall> playerBaseBalls = playerMount.getBaseBalls();

        for (int i = 0; i < playerBaseBalls.size(); i++) {
            if (Objects.equals(computerBaseBalls.get(i), playerBaseBalls.get(i))) {
                this.strikeCount++;
            } else if (computerBaseBalls.contains(playerBaseBalls.get(i))) {
                this.ballCount++;
            }
        }
    }

    private String judgeMountResult() {
        if (this.strikeCount == ZERO && this.ballCount == ZERO) {
            return NOTHING_SIGN;
        }
        if (this.strikeCount == ZERO) {
            return this.ballCount + BALL_SIGN;
        } else if (this.ballCount == ZERO) {
            return this.strikeCount + STRIKE_SIGN;
        } else {
            return this.ballCount + BALL_SIGN + " " + this.strikeCount + STRIKE_SIGN;
        }
    }

}
