package baseball.controller;

import baseball.enums.GameStatus;
import baseball.model.Computer;
import baseball.model.Game;
import baseball.model.Round;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Objects;

public class BaseballGameController {
    private final Game game;
    private final Computer computer;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController() {
        this.game = new Game();
        this.computer = new Computer();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        computer.generateSecretNumber();
        outputView.printGameStart();
    }

    public void play() {
        String computerNumber = computer.getSecretNumber();
        Round round;
        do {
            String playerNumber = inputView.getSuggestedNumber();
            round = Round.fromPlayerAndSecretNumbers(playerNumber, computerNumber);
            String result = round.generateResultMessage();
            outputView.printRoundResult(result);
        } while (!round.isCorrectGuess());
    }

    public void end() {
        outputView.printGameEnd();
        if (Objects.equals(inputView.getGameContinueChoice(), "2")) {
            game.endGame();
        }
    }

    public boolean isEnd() {
        return game.getStatus() == GameStatus.END;
    }
}
