package baseball.game;

import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGame {
    private static final int GAME_NUMBER_SIZE = 3;
    private static final int RETRY_NUMBER = 1;
    private final Computer computer;
    private final InputView inputView;
    private final OutputView outputView;
    private GameNumbers answer;

    public NumberBaseballGame() {
        this.computer = new Computer();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        setGame();
        playGame();
        endGame();
    }

    private void setGame() {
        answer = computer.generateAnswer();
    }

    private void playGame() {
        outputView.printStartGame();

        while (true) {
            GameNumbers userNumbers = inputView.readUserNumbers();
            Hint hint = computer.getHint(userNumbers);
            outputView.printHint(hint);

            if (isAllStrike(hint.getStrike())) {
                break;
            }
        }
    }

    private boolean isAllStrike(int strike) {
        return strike == GAME_NUMBER_SIZE;
    }

    private void endGame() {
        outputView.printEndGame();

        if (inputView.readRetryNumber() == RETRY_NUMBER) {
            run();
        }
    }
}
