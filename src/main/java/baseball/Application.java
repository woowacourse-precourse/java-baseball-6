package baseball;

import baseball.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame(new OutputView());
        game.start();
    }
}
