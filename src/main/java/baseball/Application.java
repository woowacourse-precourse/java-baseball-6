package baseball;

import baseball.game.Computer;
import baseball.game.Game;
import baseball.game.InputHandler;
import baseball.game.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        Player player = new Player();
        InputHandler inputHandler = new InputHandler();
        Game game = new Game(computer, player, inputHandler);

        game.start();
    }
}
