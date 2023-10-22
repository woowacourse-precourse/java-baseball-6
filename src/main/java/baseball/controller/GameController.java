package baseball.controller;

import baseball.model.Game;
import baseball.model.GameResult;
import baseball.utils.Constant;
import baseball.validation.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Game game;

    public GameController() {
        OutputView.printGameStart();
    }

    public void run() {
        this.game = new Game();
        do {
            playGame();
        } while (checkRestartOrExit());
    }

    public void playGame() {
        GameResult gameResult;
        game.setComputerNumber();
        do {
            String inputNumber = InputView.getInputNumber();
            game.setPlayerNumber(inputNumber);
            gameResult = game.getGameResult();
            new OutputView(gameResult).printResult();
        } while (gameResult.getStrike() != Constant.STRIKE_EXIT_COUNT);
        OutputView.printGameClear();
    }

    private boolean checkRestartOrExit() {
        String input = InputView.getInputRestartOrExit();
        return InputValidation.validateInputRestartOrExit(input);
    }
}
