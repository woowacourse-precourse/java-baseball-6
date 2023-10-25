package baseball;

import game.Game;
import util.PlayerFactory;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final int ballNumberLength = 3;
        Game game = new Game(PlayerFactory.getUser(ballNumberLength), PlayerFactory.getComputer());
        game.run();
    }
}
