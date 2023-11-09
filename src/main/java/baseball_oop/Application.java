package baseball_oop;

import baseball_oop.domain.game.BaseBallGame;
import baseball_oop.domain.game.Game;
import baseball_oop.domain.participant.computer.Hitter;
import baseball_oop.domain.participant.player.Pitcher;
import baseball_oop.domain.participant.judgment.Umpire;

public class Application {

    public static void main(String[] args) {
        Game game = new BaseBallGame(
                new Hitter(),
                new Pitcher(),
                new Umpire()
        );
        game.start();
    }
}
