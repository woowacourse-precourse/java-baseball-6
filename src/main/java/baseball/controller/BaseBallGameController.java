package baseball.controller;

import baseball.enums.GameContinuationOption;
import baseball.model.Game;
import baseball.model.Round;
import baseball.model.Turn;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final Game game;
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController() {
        this.game = Game.start();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.printGameStart();
        while (!isGameEnd()) {
            playRound();
            stopGame();
        }
    }

    public void playRound() {
        String computerNumber = new Round().getRandomNumber();
        Turn turn;
        do {
            String playerNumber = inputView.getPlayerNumber();
            InputValidator.validatePlayerNumber(playerNumber);
            turn = Turn.fromPlayerAndComputerNumbers(playerNumber, computerNumber);
            String result = turn.generateResult();
            outputView.printTurnResult(result);
        } while (!turn.isThreeStrike());
    }

    public void stopGame() {
        outputView.printGameStop();
        String userInput = inputView.getGameContinuationInput();
        GameContinuationOption option = GameContinuationOption.fromString(userInput);
        if (option == GameContinuationOption.END) {
            game.end();
        }
    }

    public boolean isGameEnd() {
        return game.isEnd();
    }
}
