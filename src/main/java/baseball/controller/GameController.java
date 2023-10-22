package baseball.controller;

import baseball.model.Game;
import baseball.model.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Game game;

    public GameController() {
        OutputView.printGameStart();
    }

    public void run() {
        this.game = new Game();
    }

    public void playGame() {
        String inputNumber = InputView.getInputNumber();
        game.setPlayerNumber(inputNumber);

        GameResult gameResult = game.getGameResult();
        new OutputView(gameResult).printResult();
    }
}
