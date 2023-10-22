package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        OutputView.start();
        do {
            game.play();
            InputView.restart();
        } while (game.isRestart());
    }
}
