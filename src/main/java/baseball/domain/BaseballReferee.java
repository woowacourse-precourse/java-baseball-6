package baseball.domain;

import static baseball.constants.CommonConstants.MAX_NUMBER_SIZE;

public class BaseballReferee {

    public Hint compare(BaseballNumber computerNumbers, BaseballNumber playerNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            if (computerNumbers.getNumberByIndex(i) == playerNumbers.getNumberByIndex(i)) {
                strike++;
                continue;
            }
            if (computerNumbers.isNumberContains(playerNumbers.getNumberByIndex(i))) {
                ball++;
            }
        }
        return new Hint(strike, ball);
    }
}
