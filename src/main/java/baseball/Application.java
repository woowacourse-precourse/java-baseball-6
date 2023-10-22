package baseball;

import baseball.controller.BaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printGameStart();
        BaseballGame baseballGame = new BaseballGame();
        do {
            baseballGame.gameStart();
            OutputView.printGameEnd();
        } while(baseballGame.restartFlag());
    }
}