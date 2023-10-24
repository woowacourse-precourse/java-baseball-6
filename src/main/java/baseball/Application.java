package baseball;

import baseball.controller.BaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printStartGame();

        BaseballGame baseballGame = new BaseballGame();
        baseballGame.startGame();

    }
}
