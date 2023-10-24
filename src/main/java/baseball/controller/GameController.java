package baseball.controller;

import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private OutputView outputView = new OutputView();

    private ComputerController computerController = new ComputerController();

    private PlayerController playerController = new PlayerController();

    public GameController() {
        outputView.gameStart();
    }

    public void playGame() {
        Boolean isRunning = true;
        while (isRunning) {
            computerController.saveRandomNumbers();
            proceedGame();
            isRunning = askIfContinue();
        }
    }

    private void proceedGame() {
        Boolean isCorrectAnswer = false;
        while (!isCorrectAnswer) {
            List<Integer> inputNumbers = playerController.readAndValidateInputNumbers();
            computerController.provideHint(inputNumbers);
            isCorrectAnswer = computerController.checkCorrectAnswer();
        }
        outputView.notifyCorrectAnswer();
    }

    private Boolean askIfContinue() {
        outputView.askRestartOrExit();
        Integer answer = playerController.restartOrOver();
        if (answer == 1) {
            return true;
        }
        return false;
    }
}
