package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame() {
        outputView.printStartGame();
        computerController.startGame(gameNumber);

        repeatGussingAnswer();
    }

    private void repeatGussingAnswer() {
        boolean correctAnswer = false;

        while (!correctAnswer) {
            gameNumber.setInputNumber(inputView.enterGameNumber());

            computerController.compareNumbers(gameNumber);
            computerController.provideHint();

            correctAnswer = computerController.isSuccessGame();
            if (correctAnswer) {
                outputView.printEndGame();
            }
        }
    }
}
