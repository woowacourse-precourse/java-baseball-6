package baseball;

import baseball.game.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(new InputView(), new OutputView());
        baseballGame.start();
    }
}
