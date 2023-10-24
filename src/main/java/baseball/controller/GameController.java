package baseball.controller;

import baseball.common.InputAnswerValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    private static final String RESTART_YES_ANSWER = "1";
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    ComputerController computerController = new ComputerController();

    public void gameStart() {
        outputView.printStartGame();
        computerController.startGame();
        endGame();
    }

    public void endGame() {
        outputView.printEndGame();
        outputView.printAskRestartGame();
        String inputAnswer = inputView.restartAnswer();
        InputAnswerValidator.validate(inputAnswer);
        if(inputAnswer.equals(RESTART_YES_ANSWER)) {
            gameStart();
        }
    }
}
