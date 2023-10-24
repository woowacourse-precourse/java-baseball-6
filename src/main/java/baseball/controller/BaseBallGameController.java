package baseball.controller;

import baseball.enums.GameStatus;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.Round;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final Game game;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController() {
        this.game = new Game();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void play() {
        outputView.printGameStart();
        Computer computer = new Computer();
        String computerNumber = computer.getSecretNumber();
        Round round;
        do {
            String playerNumber = inputView.getSuggestedNumber();
            InputValidator.validatePlayerNumber(playerNumber);
            round = Round.fromPlayerAndSecretNumbers(playerNumber, computerNumber);
            String result = round.generateResultMessage();
            outputView.printRoundResult(result);
        } while (!round.isCorrectGuess());
    }

    public void end() {
        outputView.printGameEnd();
        String continueChoice = inputView.getGameContinueChoice();
        InputValidator.validateGameChoice(continueChoice);
        if (continueChoice.equals("2")) {
            game.endGame();
        }
    }

    public boolean isEnd() {
        return game.getStatus() == GameStatus.END;
    }
}
