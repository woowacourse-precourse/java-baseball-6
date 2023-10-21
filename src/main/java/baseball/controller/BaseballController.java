package baseball.controller;

import baseball.constants.BaseballRole;
import baseball.model.CheckBallAndStrike;
import baseball.model.Player;
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
        CheckBallAndStrike checkBallAndStrike = new CheckBallAndStrike();
        while (checkBallAndStrike.isThreeStrike()){
            requestExpectedNumber();
            resultExpectedNumber(checkBallAndStrike);
        }
        outputView.printClearBaseBallGame();
    }

    private void requestExpectedNumber() {
        String expectedNumber = inputView.inputExpectedNumber();
        player.changeExpectedNumbers(expectedNumber);
    }

    private void resultExpectedNumber(CheckBallAndStrike checkBallAndStrike) {
        checkBallAndStrike.updateBallAndStrike(player);
        outputView.printStatusBallAndStrike(checkBallAndStrike.statusBallAndStrike());
    }
}
