package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String WRONG_ANSWER_INPUT_MESSAGE = "1 혹은 2만 입력하세요.";
    private static final String BASEBALL_RESTART_ANSWER = "1";
    private static final String BASEBALL_END_ANSWER = "2";
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame() {
        boolean gameState = true;
        while (gameState) {
            outputView.printStartGame();
            computerController.startGame(gameNumber);

            repeatGussingAnswer();
            gameState = askRestartGame();
        }
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

    private boolean askRestartGame() {
        String answer = inputView.enterRestartAnswer();
        return tryRestartGame(answer);
    }

    private boolean tryRestartGame(String answer) {
        if (answer.equals(BASEBALL_RESTART_ANSWER)) {
            return true;
        } else if (answer.equals(BASEBALL_END_ANSWER)) {
            return false;
        } throw new IllegalArgumentException(WRONG_ANSWER_INPUT_MESSAGE);
    }
}
