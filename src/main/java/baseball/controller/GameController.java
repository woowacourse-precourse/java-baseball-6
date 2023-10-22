package baseball.controller;

import baseball.model.Game;
import baseball.model.GameResult;
import baseball.utils.Constant;
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
        GameResult gameResult;
        do {
            String inputNumber = InputView.getInputNumber();
            game.setPlayerNumber(inputNumber);
            gameResult = game.getGameResult();
            new OutputView(gameResult).printResult();
        } while (gameResult.getStrike() == Constant.STRIKE_END_COUNT);
        OutputView.printGameClear();
    }
}
