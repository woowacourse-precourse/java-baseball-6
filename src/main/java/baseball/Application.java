package baseball;

import baseball.game.Game;
import baseball.game.NumberGengerator;
import baseball.view.GameView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game(new NumberGengerator(), new GameView());
        game.run();
    }
}