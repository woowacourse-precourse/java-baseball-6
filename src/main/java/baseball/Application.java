package baseball;

import baseball.game.Game;
import baseball.game.GameStatus;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        while (game.status != GameStatus.EXIT) {
            game.next();
        }
    }
}
