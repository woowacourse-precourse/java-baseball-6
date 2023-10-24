package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.service.BaseballService;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

public class BaseballController {
    private static final BaseballService baseballService = new BaseballService();

    public void play() {
        BaseballNumber computerBaseballNumber = startBaseballGame();
        playBaseballGame(computerBaseballNumber);
        reStartOrEndBaseballGame();
    }

    private BaseballNumber startBaseballGame() {
        BaseballOutputView.printStartMessage();
        return baseballService.initializeComputerNumber();
    }

    private void playBaseballGame(BaseballNumber computerBaseballNumber) {
        BaseballScore resultScore = new BaseballScore();
        while (!resultScore.isStrikeThree()) {
            BaseballNumber userBaseballNumber = baseballService.initializeUserNumber(
                    BaseballInputView.readUserNumber());
            resultScore = baseballService.compareBaseballNumber(computerBaseballNumber, userBaseballNumber);
            resultScore.printBaseballScore();
        }
        BaseballOutputView.printEndMessage();
    }

    private void reStartOrEndBaseballGame() {
        if (baseballService.isContinueGame(BaseballInputView.readRestartOrEnd())) {
            play();
        }
    }
}
