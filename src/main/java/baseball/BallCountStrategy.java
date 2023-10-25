package baseball;

import baseball.domain.BaseballNumber;

public class BallCountStrategy extends CountStrategy {

    public BallCountStrategy(BaseballNumber computerBaseballNumber, BaseballNumber userBaseballNumber) {
        super(computerBaseballNumber, userBaseballNumber);
    }

    @Override
    public int counting(int index) {
        int count = 0;
        for (int i = 1; i <= 2; i++) {
            int userBaseballNumberIndex = (index + i) % 3;
            count += plusCount(computerBaseballNumber.get(index), userBaseballNumber.get(userBaseballNumberIndex));
        }
        return count;
    }
}
