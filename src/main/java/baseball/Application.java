package baseball;

import baseball.controller.BaseballGame;
import baseball.domain.Computer;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new OutputView(), new Computer()
        );
        baseballGame.start();
    }
}
