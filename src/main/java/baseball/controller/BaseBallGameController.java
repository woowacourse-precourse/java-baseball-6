package baseball.controller;

import baseball.enums.GameEndOption;
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
        Round round;
        String computerNumber = new Computer().getRandomNumber();
        do {
            String playerNumber = inputView.getSuggestedNumber();
            InputValidator.validatePlayerNumber(playerNumber);
            round = Round.fromPlayerAndComputerNumbers(playerNumber, computerNumber);
            String result = round.generateResultMessage();
            outputView.printRoundResult(result);
        } while (!round.isEnd());
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
