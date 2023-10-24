package baseball;

import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.view.GameView;

public class GameManager {

    private GameController controller;
    private Computer computer;

    public GameManager() {
        this.controller = new GameController();
    }

    public void start() {
        GameView.printGameStartMessage();
        do {
            setGame();
            playGame();
            GameView.printRetryInputMessage();
        } while (controller.getIsRetry());
    }

    private void playGame() {
        Boolean isGameEnd = false;
        while (!isGameEnd) {
            GameView.printNumberInputMessage();
            GameResult result = computer.calculateGameResult(controller.getInputGameNumber());
            GameView.printResultMessage(result);
            isGameEnd = result.isAnswer();
        }
        GameView.printGameEndMessage();
    }

    private void setGame() {
        this.computer = new Computer();
    }
}
