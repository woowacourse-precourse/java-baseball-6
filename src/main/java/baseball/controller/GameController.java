package baseball.controller;

import baseball.model.Computer;
import baseball.model.GameCommand;
import baseball.model.Number;
import baseball.model.UserNumbers;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printGameStart();
        GameCommand gameCommand = GameCommand.RESTART;

        while (GameCommand.isRestartCommand(gameCommand)) {
            playGame();
            gameCommand = askForRestart();
        }
    }

    private void playGame() {
        Computer computer = Computer.createFromGeneratedNumbers(new RandomNumberGenerator());
        List<Number> userGuess = new ArrayList<>();

        while (!isGameOver(computer, userGuess)) {
            userGuess = getUserInputNumbers();
            int ballCount = computer.countBalls(userGuess);
            int strikeCount = computer.countStrikes(userGuess);
            outputView.printGameResult(ballCount, strikeCount);
        }
        outputView.printGameEnd();
    }

    private boolean isGameOver(final Computer computer, final List<Number> inputNumbers) {
        return computer.isThreeStrikes(inputNumbers);
    }

    private List<Number> getUserInputNumbers() {
        outputView.printInputNumbersMessage();
        String input = inputView.readInput();
        UserNumbers userNumbers = UserNumbers.createFromInput(input);
        return userNumbers.getSelectedNumbers();
    }

    private GameCommand askForRestart() {
        outputView.printRestartMessage();
        String choice = inputView.readInput();
        return GameCommand.createFromInput(choice);
    }
}
