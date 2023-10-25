package baseball;

import baseball.game.BaseBallGame;
import baseball.game.Game;

public class Application {
    public static void main(String[] args) {

        Game game = new BaseBallGame();

        Machine machine = new Machine(game);

        User.obtainMachine(machine);

        User.startGame();

    }
}
