package baseball.controller;

import baseball.view.OutputView;

public class MainController {
    private boolean isRunning = false;
    BaseballGameController baseballGameController;

    public MainController(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void startProgram() {
        OutputView.printStartProgramMessage();
        while (isRunning) {
            baseballGameController = new BaseballGameController();
            baseballGameController.startGame();

            isRunning = baseballGameController.whetherRestart();
        }
    }
}
