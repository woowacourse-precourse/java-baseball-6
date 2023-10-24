package baseball;

import baseball.controller.NumberBaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printGameStart();

        NumberBaseballGame numberBaseballGame = new NumberBaseballGame();
        numberBaseballGame.playGame();
    }
}