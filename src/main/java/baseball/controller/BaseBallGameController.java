package baseball.controller;

import baseball.enums.GameEndOption;
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
        Round round;
        String computerNumber = new Computer().getRandomNumber();
        do {
            String playerNumber = inputView.getSuggestedNumber();
            InputValidator.validatePlayerNumber(playerNumber);
            round = Round.fromPlayerAndComputerNumbers(playerNumber, computerNumber);
            String result = round.generateResultMessage();
            outputView.printRoundResult(result);
        } while (!round.isCorrectGuess());
    }

    public void stop() {
        outputView.printGameStop();
        String continueChoice = inputView.getGameContinueChoice();
        GameEndOption option = GameEndOption.fromString(continueChoice);
        if (option == GameEndOption.TERMINATE) {
            game.endGame();
        }
    }

    public boolean isEnd() {
        return game.getStatus() == GameStatus.END;
    }
}
