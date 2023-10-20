package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;

import java.util.Optional;

public class StrikeNum implements ResultNum {
    private final int strikeNum;

    public StrikeNum() {
        this.strikeNum = 0;
    }

    public StrikeNum(int ballNum) {
        this.strikeNum = ballNum;
    }

    @Override
    public ResultNum update(BallResult ballResult) {
        if (ballResult.isStrike()) {
            return new StrikeNum(strikeNum + 1);
        }
        return this;
    }

    @Override
    public Optional<String> getResult() {
        if (strikeNum != 0) {
            return Optional.of(strikeNum + "스트라이크");
        }
        return Optional.empty();
    }
}