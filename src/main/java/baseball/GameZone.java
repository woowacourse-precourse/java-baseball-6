package baseball;

import baseball.model.Announcer;
import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.model.generator.ComputerNumberGenerator;
import baseball.model.generator.PlayerNumberGenerator;

public class GameZone {
    public void initGame() {

        Computer computer = new Computer(new ComputerNumberGenerator());
        Player player = new Player(new PlayerNumberGenerator());
        Judge judge = new Judge();
        Announcer announcer = new Announcer();

        Game game = new Game(computer, player, judge, announcer);
        start(game);
    }

    private void start(Game game) {
        game.start();
        close(game);
    }

    private void close(Game game) {
        if (game.checkRestart()) {
            initGame();
        }
    }
}
