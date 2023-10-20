package baseball;

import baseball.player.Opponent;
import baseball.player.User;

public class Application {
    public static void main(String[] args) {

        User user = new User();
        Opponent opponent = new Opponent();
        Score score = new Score();
        Game game = new Game(opponent, user, score);

        game.newGame();

    }
}
