package baseball.version2;

import static baseball.version2.Constants.Value.CONTINUE_NUMBER;

import baseball.version2.controller.Controller;

public class Game {

    private final Controller controller;

    public Game() {
        this.controller = new Controller();
    }

    public void run() {
        int continueDecision = CONTINUE_NUMBER;
        while (continueDecision == CONTINUE_NUMBER) {
            controller.settingGame();
            boolean isCorrect = false;
            while (!isCorrect) {
                isCorrect = controller.startGame();
            }
            continueDecision = controller.isContinue();
        }
    }
}
