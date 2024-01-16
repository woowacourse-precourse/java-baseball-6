package baseball.domain;

/**
 * Inning : 한 이닝의 결과를 계산하고 판정하는 역할. 의존성: BaseBallMount, Sign
 */
public class Inning {
    public static final int ZERO = 0;
    public static final int FULL_STRIKE_COUNT = 3;

    private final Pitch computerPitch;
    private final Pitch playerPitch;
    private int strikeCount = 0;
    private int ballCount = 0;

    public Inning(Pitch computerPitch, Pitch playerPitch) {
        this.computerPitch = computerPitch;
        this.playerPitch = playerPitch;
    }


    public String referee() {
        this.strikeCount = computerPitch.calculateStrikeCount(playerPitch);
        this.ballCount = computerPitch.calculateBallCount(playerPitch);
        return judgeMountResult();
    }

    public boolean isAllStrike() {
        return strikeCount == FULL_STRIKE_COUNT && ballCount == ZERO;
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
