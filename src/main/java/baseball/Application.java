package baseball;

import baseball.play.Print;
import baseball.play.PlayGame;
import baseball.model.Computer;
import baseball.model.User;

public class Application {

    private static final PlayGame runGame = new PlayGame(new Print(), new Computer(), new User());

    public static void main(String[] args) {
        runGame.startGame();
    }

}
