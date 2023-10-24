package baseball.game;

import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGame {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int RETRY_NUMBER = 1;
    private final Computer computer;
    private GameNumbers answer;
    private GameState gameState;

    public NumberBaseballGame() {
        this.computer = new Computer();
        OutputView.printStartGame();
    }

    public void run() {
        setGame();
        playGame();
        endGame();
    }

    private void setGame() {
        answer = computer.generateAnswer();
        gameState = GameState.PLAY;
    }

    private void playGame() {
        while (gameState == GameState.PLAY) {
            GameNumbers userNumbers = InputView.readUserNumbers();
            Hint hint = computer.getHint(userNumbers);
            OutputView.printHint(hint);

            if (isAllStrike(hint.getStrike())) {
                gameState = GameState.END;
            }
        }
    }

    private boolean isAllStrike(int strike) {
        return strike == GAME_NUMBER_SIZE;
    }

    private void endGame() {
        OutputView.printEndGame();

        if (InputView.readRetryNumber() == RETRY_NUMBER) {
            run();
        }
    }
}
