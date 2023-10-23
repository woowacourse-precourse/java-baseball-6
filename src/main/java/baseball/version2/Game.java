package baseball.version2;

import static baseball.version2.constants.Value.CONTINUE_NUMBER;

import baseball.version2.controller.Controller;
import baseball.version2.dto.ComputerAnswerDto;

public class Game {
    private final Controller controller;

    public Game() {
        this.controller = new Controller();
    }

    public void run() {
        controller.runGame();
        int continueDecision = CONTINUE_NUMBER;
        while (continueDecision == CONTINUE_NUMBER) {
            ComputerAnswerDto computerAnswer = controller.settingGame();
            playGame(computerAnswer);
            continueDecision = controller.isContinue();
        }
    }

    private void playGame(ComputerAnswerDto computerAnswer) {
        boolean isCorrect = false;
        while (!isCorrect) {
            isCorrect = controller.startGame(computerAnswer);
        }
    }
}
