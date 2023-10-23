package baseball;

import baseball.game.BaseballGame;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new OutputView());
        baseballGame.start();
    }
}
