package baseball.controller;

import baseball.constants.BaseballRole;
import baseball.model.baseball.BaseballManager;
import baseball.model.player.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Player player;

    public BaseballController(Player player) {
        this.outputView = new OutputView();
        this.inputView = new InputView(outputView);
        this.player = player;
    }

    public void run(){
        outputView.printStartBaseBallGameMessage();

        while (true){
            startGame();
            int restartMessage = inputView.inputRestartMessage();
            if (BaseballRole.isGameExit(restartMessage)) break;
        }
    }

    private void startGame() {
        BaseballManager baseballManager = new BaseballManager();
        while (baseballManager.isThreeStrike()){
            requestExpectedNumber();
            resultExpectedNumber(baseballManager);
        }
        outputView.printClearBaseBallGame();
    }

    private void requestExpectedNumber() {
        String expectedNumber = inputView.inputExpectedNumber();
        player.changeExpectedNumbers(expectedNumber);
    }

    private void resultExpectedNumber(BaseballManager baseballManager) {
        baseballManager.updateBallAndStrike(player);
        outputView.printStatusBallAndStrike(baseballManager.statusBallAndStrike());
    }
}
