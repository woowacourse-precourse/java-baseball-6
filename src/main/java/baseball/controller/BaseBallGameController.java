package baseball.controller;

import baseball.enums.GameEndOption;
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

    public void start() {
        outputView.printGameStart();
        while (!isEnd()) {
            play();
            stop();
        }
    }

    public void play() {
        Turn turn;
        String computerNumber = new Round().getRandomNumber();
        do {
            String playerNumber = inputView.getSuggestedNumber();
            InputValidator.validatePlayerNumber(playerNumber);
            turn = Turn.fromPlayerAndComputerNumbers(playerNumber, computerNumber);
            String result = turn.generateResultMessage();
            outputView.printTurnResult(result);
        } while (!turn.isEnd());
    }

    public void stop() {
        outputView.printGameStop();
        String continueChoice = inputView.getGameContinueChoice();
        GameEndOption option = GameEndOption.fromString(continueChoice);
        if (option == GameEndOption.TERMINATE) {
            game.end();
        }
    }

    public boolean isEnd() {
        return game.isEnd();
    }
}
