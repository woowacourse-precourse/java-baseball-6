package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        outputView.printStartGame();
        process();
    }

    private void process() {
        BaseballGame baseballGame = new BaseballGame();
        do {
            String inputPlayerBall = inputView.readPlayerBall();
            Player player = new Player(inputPlayerBall);
            String gameResult = baseballGame.getResult(player);
            outputView.printResult(gameResult);
        } while (!baseballGame.isGameEnd());
    }
}
