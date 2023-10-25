package baseball;

import baseball.controller.GameController;
import baseball.model.Computer;
import baseball.model.GameResult;
import baseball.view.GameView;

public class GameManager {

    private GameController controller;
    private GameView view;

    public GameManager() {
        this.controller = new GameController();
        this.view = new GameView();
    }

    public void start() {
        view.printGameStartMessage();
        do {
            playGame();
            view.printGameEndMessage();
            view.printInputGameDecisionMessage();
        } while (controller.getGameDecision().isRetry());
    }

    private void playGame() {
        Computer computer = new Computer();
        GameResult result;
        do {
            view.printInputNumberMessage();
            result = computer.calculateGameResult(controller.getInputGameNumber());
            view.printResultMessage(result);
        } while (!result.isAnswer());
    }
}
