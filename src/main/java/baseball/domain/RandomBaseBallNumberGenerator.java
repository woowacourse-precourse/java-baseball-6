package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import exception.DuplicateBaseBallNumber;
import exception.OutOfBaseBallNumbersSize;

public final class RandomBaseBallNumberGenerator implements BaseBallNumberGenerator {

    @Override
    public AnswerNumbers create() {
        AnswerNumbers baseballNumbers = AnswerNumbers.empty();
        while (baseballNumbers.size() < AnswerNumbers.MAX_BASE_BALL_SIZE) {
            addBaseBallNumber(baseballNumbers);
        }
        return baseballNumbers;
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(AnswerNumbers.MIN_BASE_BALL_NUMBER, AnswerNumbers.MAX_BASE_BALL_NUMBER);
    }

    private void addBaseBallNumber(AnswerNumbers baseballNumbers) {
        try {
            int number = createRandomNumber();
            baseballNumbers.add(number);
        } catch (DuplicateBaseBallNumber | OutOfBaseBallNumbersSize ignored) {
            return;
        }
    }
}
