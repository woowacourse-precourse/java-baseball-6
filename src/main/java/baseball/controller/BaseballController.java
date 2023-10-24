package baseball.controller;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballScore;
import baseball.service.BaseballService;
import baseball.view.BaseballInputView;
import baseball.view.BaseballOutputView;

/*
 * 숫자야구 게임정보를 사용자와 주고받는 클래스
 * */

public class BaseballController {
    private static final BaseballService baseballService = new BaseballService();

    private BaseballNumber computerBaseballNumber;

    public void play() {
        startBaseballGame();
        playBaseballGame(computerBaseballNumber);
        reStartOrEndBaseballGame();
    }

    private void startBaseballGame() {
        BaseballOutputView.printStartMessage();
        computerBaseballNumber = baseballService.initializeComputerNumber();
    }

    private void playBaseballGame(BaseballNumber computerBaseballNumber) {
        BaseballScore resultScore = new BaseballScore();
        while (!baseballService.isBaseballGameEnd(resultScore)) {
            BaseballNumber userBaseballNumber = baseballService.initializeUserNumber(
                    BaseballInputView.readUserNumber());
            resultScore = baseballService.compareBaseballNumber(computerBaseballNumber, userBaseballNumber);
            baseballService.showResultScore(resultScore);
        }
        BaseballOutputView.printEndMessage();
    }

    private void reStartOrEndBaseballGame() {
        if (baseballService.isContinueGame(BaseballInputView.readRestartOrEnd())) {
            play();
        }
    }
}
