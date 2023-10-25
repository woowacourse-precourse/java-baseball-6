package baseball.controller;

import baseball.domain.Game;
import baseball.dto.ResultDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {
    private final Game game;

    public BaseballController() {
        this.game = new Game();
    }

    public void run() {
        OutputView.printStart();

        do {
            game.init();
            do {
                playGame();
                printGameResult();
            } while (!game.isGameOver());
        } while (isRetry());
    }

    private Boolean isRetry() {
        OutputView.printGameOver();
        String command = InputView.inputRetryOrQuit();
        return game.isRetry(command);
    }

    private void playGame() {
        String number = InputView.inputNumber();
        game.playGame(number);
    }

    private void printGameResult() {
        ResultDto gameResult = game.getGameResult();
        OutputView.printBaseballResult(gameResult);
    }
}
