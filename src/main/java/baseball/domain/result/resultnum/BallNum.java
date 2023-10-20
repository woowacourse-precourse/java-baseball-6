package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;

import java.util.Optional;

public class BallNum implements ResultNum {
    private final int ballNum;

    public BallNum() {
        this.ballNum = 0;
    }

    public BallNum(int ballNum) {
        this.ballNum = ballNum;
    }

    @Override
    public ResultNum update(BallResult ballResult) {
        if (ballResult.isBall()) {
            return new BallNum(ballNum + 1);
        }
        return this;
    }

    @Override
    public Optional<String> getResult() {
        if (ballNum != 0) {
            return Optional.of(ballNum + "볼");
        }
        return Optional.empty();
    }
}