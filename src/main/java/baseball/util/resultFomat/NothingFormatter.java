package baseball.util.resultFomat;

import baseball.model.BallCount;

public class NothingFormatter implements ResultFormatter {
    @Override
    public String format() {
        return BallCount.NOTHING.getBaseballjudgment();
    }
}
