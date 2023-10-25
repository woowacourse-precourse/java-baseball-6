package baseball.controller;

import baseball.domain.GameManager;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {
    private final GameManager gameManager;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        gameManager = new GameManager();
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void run() throws IllegalArgumentException {
        outputView.printGameStartMessage();
        while (true) {
            while (!gameManager.isGameSuccess) {
                List<Integer> result = gameManager.guessNumber(inputView.inputNumbers());
                outputView.printGameResult(result.get(0), result.get(1)); // ball, strike
            }
            outputView.printGameSuccess();
            if (gameManager.isGameRetry(inputView.inputGameCommand())) {
                gameManager.initGame();
                continue;
            }
            return;
        }
    }
}