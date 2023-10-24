package baseball;

import static baseball.model.Status.REPLAY;

import baseball.controller.GameController;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView.printStartMessage();
        GameController gameController = new GameController();
        do {
            GameView.printInputGuideMessage();
            gameController.run();
            GameView.printDoneMessage();
        } while (gameController.replayOrStop() == REPLAY);
    }
}
