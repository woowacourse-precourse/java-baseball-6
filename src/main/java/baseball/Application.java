package baseball;

import static baseball.model.Status.REPLAY;

import baseball.controller.GameController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printStartMessage();
        GameController gameController = new GameController();
        do {
            gameController.run();
        } while (gameController.replayOrStop() == REPLAY);
    }
}
