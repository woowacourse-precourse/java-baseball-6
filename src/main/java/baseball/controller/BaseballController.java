package baseball.controller;

import baseball.domain.BaseballCommand;
import baseball.domain.BaseballFlag;
import baseball.domain.BaseballResult;
import baseball.model.BaseballStadium;
import baseball.view.BaseballView;

import static baseball.domain.BaseballCommand.*;

public class BaseballController {

    private final BaseballStadium baseballStadium;
    private final BaseballView baseballView;

    public BaseballController(BaseballStadium baseballStadium, BaseballView baseballView) {
        this.baseballStadium = baseballStadium;
        this.baseballView = baseballView;
    }

    public void gameStart() {
        baseballView.gameStartMessage();
        baseballStadium.reset();
        loop();
    }

    private void loop() {
        BaseballCommand baseballCommand = RETRY;
        while(true) {
            BaseballResult baseballResult = new BaseballResult();
            baseballResult.translate(baseballStadium.userTry(baseballView.inputUserNumbersMessage()));
            baseballView.resultMessage(baseballResult);

            if (baseballResult.getTransResult().get(BaseballFlag.STRIKE) == 3) {
                baseballCommand = confirm(baseballView.inputUserCommandMessage());
                if (baseballCommand == QUIT) {
                    break;
                }
                baseballStadium.reset();
            }
        }
    }
}
