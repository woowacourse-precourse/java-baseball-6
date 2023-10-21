package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;

public final class RandomBaseBallNumberGenerator implements BaseBallNumberGenerator {

    @Override
    public BaseBallNumbers create() {
        BaseBallNumbers baseballNumbers = BaseBallNumbers.empty();
        while (baseballNumbers.size() < BaseBallNumbers.MAX_BASE_BALL_SIZE) {
            addBaseBallNumber(baseballNumbers);
        }
        return baseballNumbers;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(BaseBallNumbers.MIN_BASE_BALL_NUMBER, BaseBallNumbers.MAX_BASE_BALL_NUMBER);
    }

    private void addBaseBallNumber(BaseBallNumbers baseballNumbers) {
        try {
            int number = createRandomNumber();
            baseballNumbers.add(number);
        } catch (DuplicateBaseBallNumber | OutOfBaseBallNumbersSize ignored) {
            return;
        }
    }
}
