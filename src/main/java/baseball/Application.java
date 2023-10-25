package baseball;

import baseball.game.Game;
import baseball.player.Computer;
import baseball.player.User;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User();
        Game game = new Game(computer, user);
        game.play();
    }
}
