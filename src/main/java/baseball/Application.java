package baseball;

import baseball.game.Computer;
import baseball.game.Game;
import baseball.game.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        Player player = new Player();
        Game game = new Game(computer, player);

        game.start();
    }
}
