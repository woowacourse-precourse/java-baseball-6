package baseball;

import static baseball.model.Status.REPLAY;

import baseball.controller.GameController;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView.printStartMessage();
        GameController gameController = new GameController();
        do {
            gameController.run();
        } while (gameController.replayOrStop() == REPLAY);
    }
}
