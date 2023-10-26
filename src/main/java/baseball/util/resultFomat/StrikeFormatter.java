package baseball.util.resultFomat;

import baseball.model.BallCount;

public class StrikeFormatter implements ResultFormatter {
    private final int strike;

    public StrikeFormatter(int strike) {
        this.strike = strike;
    }

    @Override
    public String format() {
        return strike + BallCount.STRIKE.getBaseballjudgment();
    }
}

