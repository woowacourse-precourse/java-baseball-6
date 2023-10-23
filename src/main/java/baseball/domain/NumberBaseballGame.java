package baseball.domain;

import baseball.domain.dto.Result;
import baseball.global.constant.RuleValue;
import baseball.global.util.RandomBaseballNumberGenerator;

import java.util.List;

public class NumberBaseballGame {

    private BaseballNumber computerNumber;
    private final Referee referee = new Referee();

    public void initGameSetting(){
        computerNumber = new BaseballNumber(RandomBaseballNumberGenerator.generateRandomBaseballNumbers(RuleValue.BASEBALL_NUMBER_SIZE));
    }
    public Result makeResult(List<Integer> playerInput){
        BaseballNumber playerNumber = new BaseballNumber(playerInput);
        return referee.alertResult(computerNumber, playerNumber);
    }

}
