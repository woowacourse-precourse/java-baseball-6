package baseball;

import baseball.domain.Game;
import baseball.util.RandomNumberUtil;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game;
        do {
            game = new Game(RandomNumberUtil.makeRandomComputerBalls());
        } while (!game.isGameOver());

    }
}
