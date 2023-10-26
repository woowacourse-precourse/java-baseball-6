package baseball;

import baseball.domain.BaseballNumber;

public class StrikeCountStrategy extends CountStrategy {

    public StrikeCountStrategy(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        super(computerBaseballNumber, userBaseballNumber);
    }

    @Override
    public int counting(int index) {
        return computerBaseballNumber.get(index) == userBaseballNumber.get(index) ? 1 : 0;
    }
}
