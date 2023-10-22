package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    public static final String CONTINUE = "1";
    public static final String END = "2";
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
        outputView.printEndGame();
        continueGame();
    }

    private void continueGame() {
        boolean gameRunning = true;
        while (gameRunning) {
            String inputContinueGame = inputView.readRetryGame();
            if (isEndGame(inputContinueGame)) {
                gameRunning = false;
            }
            if (isContinueGame(inputContinueGame)) {
                process();
                return;
            }
        }
    }

    private boolean isEndGame(final String input) {
        return END.equals(input);
    }

    private boolean isContinueGame(final String input) {
        return CONTINUE.equals(input);
    }
}
