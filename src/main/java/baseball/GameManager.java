package baseball;

import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.view.GameView;

public class GameManager {

    private GameController controller;
    private GameView view;
    private Computer computer;

    public GameManager() {
        this.controller = new GameController();
        this.view = new GameView();
    }

    public void start() {
        view.printGameStartMessage();
        do {
            setGame();
            playGame();
            view.printInputGameDecisionMessage();
        } while (controller.getGameDecision().isRetry());
    }

    private void playGame() {
        Boolean isGameEnd = false;
        while (!isGameEnd) {
            view.printNumberInputMessage();
            GameResult result = computer.calculateGameResult(controller.getInputGameNumber());
            view.printResultMessage(result);
            isGameEnd = result.isAnswer();
        }
        view.printGameEndMessage();
    }

    private void setGame() {
        this.computer = new Computer();
    }
}
