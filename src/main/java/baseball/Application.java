package baseball;

import baseball.domain.computer.Computer;
import baseball.domain.computer.ComputerService;
import baseball.domain.game.Game;
import baseball.domain.player.Player;
import baseball.domain.player.PlayerService;


public class Application {
    public static void main(String[] args) {
        Game game = new Game(new ComputerService(new Computer()), new PlayerService(new Player()));
        game.play();
    }
}
