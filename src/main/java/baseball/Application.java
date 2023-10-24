package baseball;

import baseball.domain.User;
import baseball.game.Game;

public class Application {
    public static void main(String[] args) {

        Game game = new Game();
        User gameUser = new User();

        game.welcome(gameUser);
        do {
            game.play(gameUser);
        } while (gameUser.isReady());
    }
}