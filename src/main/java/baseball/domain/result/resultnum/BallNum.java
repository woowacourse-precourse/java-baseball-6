package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;

import java.util.Optional;

import static baseball.domain.util.RandomBallGenerator.ZERO;

public class BallNum implements ResultNum {
    protected static final int ONE = 1;
    private static final String BALL = "볼";
    private final int ballNum;

    public BallNum() {
        this.ballNum = ZERO;
    }

    public BallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    @Override
    public ResultNum update(BallResult ballResult) {
        if (ballResult.isBall()) {
            return new BallNum(ballNum + ONE);
        }
        return this;
    }

    @Override
    public Optional<String> getResult() {
        if (ballNum != ZERO) {
            return Optional.of(ballNum + BALL);
        }
        return Optional.empty();
    }

    @Override
    public boolean isGameEnd() {
        return ballNum == ZERO;
    }
}