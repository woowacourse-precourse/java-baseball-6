package baseball;

import baseball.controller.BaseballGame;
import baseball.model.GameRestart;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printGameStartMessage();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.start();
        } while (GameRestart.restart());
    }
}
