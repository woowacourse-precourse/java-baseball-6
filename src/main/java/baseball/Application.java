package baseball;

import baseball.domain.Game;
import baseball.util.RandomNumberUtil;


public class Application {
    public static void main(String[] args) {
        Game game;
        do {
            game = new Game(RandomNumberUtil.makeRandomComputerBalls());
        } while (!game.isGameOver());

    }
}
