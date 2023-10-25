package baseball.domain;

import baseball.domain.dto.Result;
import baseball.global.constant.RuleValue;
import baseball.global.util.ListUtil;

public class NumberBaseballGame {
    private final Referee referee;
    private BaseballNumber computerNumber;

    public NumberBaseballGame() {
        this.referee = new Referee();
    }

    public void initGameSetting(){
        computerNumber = RandomBaseballNumberGenerator.generateRandomBaseballNumber(RuleValue.BASEBALL_NUMBER_SIZE);
    }
    public Result makeResult(int playerInput){
        BaseballNumber playerNumber =
                new BaseballNumber(ListUtil.converseIntegerToIntList(playerInput));
        return referee.alertResult(computerNumber, playerNumber);
    }
}
