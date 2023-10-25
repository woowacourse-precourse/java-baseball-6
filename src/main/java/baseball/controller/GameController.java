package baseball.controller;

import baseball.model.Computer;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        outputView.printStart();
        Computer computer = new Computer();

        while (true) {
            List<Integer> userGuess = guessUser();
            Result result = computer.getStrikesAndBalls(userGuess);
            outputView.printResult(result);

            if (isGameWin(result)) {
                outputView.printSuccessGuess();
                break;
            }
        }

        if (askForRestart()) {
            restartGame();
        }
    }

    private List<Integer> guessUser() {
        outputView.printUserGuess();
        return inputView.readUserGuess();
    }

    private boolean isGameWin(Result result) {
        return result.getStrikes() == 3;
    }

    private boolean askForRestart() {
        outputView.printRestart();
        return inputView.readRestartOption() == 1;
    }

    private void restartGame() {
        startGame();
    }
}
