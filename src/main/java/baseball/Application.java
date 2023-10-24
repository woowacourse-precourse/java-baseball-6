package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        OutputView.printStart();
        do {
            game.play();
        } while (game.shouldRestart());
    }
}
