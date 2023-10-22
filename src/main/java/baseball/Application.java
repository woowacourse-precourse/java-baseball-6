package baseball;

import baseball.game.Print;
import baseball.game.RunGame;
import baseball.object.Computer;
import baseball.object.User;

public class Application {

    private static final RunGame runGame = new RunGame(new Print(), new Computer(), new User());

    public static void main(String[] args) {
        runGame.startGame();
    }

}
