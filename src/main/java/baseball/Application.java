package baseball;

import baseball.controller.BaseballGame;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(
                new OutputView(), new InputView(),
                new Computer(), new Player()
        );
        baseballGame.start();
    }
}
