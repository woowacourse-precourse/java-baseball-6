package baseball.game;

import baseball.view.InputView;
import baseball.view.OutputView;

public class NumberBaseballGame {
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

            if (hint.getStrike() == 3) {
                break;
            }
        }
    }

    private void endGame() {

    }
}
