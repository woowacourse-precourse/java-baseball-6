package baseball;

import baseball.play.Game;
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
