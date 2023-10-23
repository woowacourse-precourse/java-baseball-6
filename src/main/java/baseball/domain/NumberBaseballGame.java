package baseball.domain;

import baseball.global.constant.RuleValue;
import baseball.global.util.RandomBaseballNumberGenerator;

public class NumberBaseballGame {

    private BaseballNumber computerNumber;

    public void initGameSetting(){
        computerNumber = new BaseballNumber(RandomBaseballNumberGenerator.generateRandomBaseballNumbers(RuleValue.BASEBALL_NUMBER_SIZE));
    }
}
