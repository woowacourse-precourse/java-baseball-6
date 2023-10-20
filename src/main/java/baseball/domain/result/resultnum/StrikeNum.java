package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;

import java.util.Optional;

import static baseball.domain.result.resultnum.BallNum.ONE;
import static baseball.domain.util.RandomBallGenerator.SIZE_OF_NUMBER;
import static baseball.domain.util.RandomBallGenerator.ZERO;

public class StrikeNum implements ResultNum {
    private static final String STRIKE = "스트라이크";
    private final int strikeNum;

    public StrikeNum() {
        this.strikeNum = ZERO;
    }

    public StrikeNum(int ballNum) {
        this.strikeNum = ballNum;
    }

    @Override
    public ResultNum update(BallResult ballResult) {
        if (ballResult.isStrike()) {
            return new StrikeNum(strikeNum + ONE);
        }
        return this;
    }

    @Override
    public Optional<String> getResult() {
        if (strikeNum != ZERO) {
            return Optional.of(strikeNum + STRIKE);
        }
        return Optional.empty();
    }

    @Override
    public boolean isGameEnd() {
        return strikeNum == SIZE_OF_NUMBER;
    }
}