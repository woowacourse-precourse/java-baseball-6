package baseball;

import baseball.play.Print;
import baseball.play.RunGame;
import baseball.model.Computer;
import baseball.model.User;

public class Application {

    private static final RunGame runGame = new RunGame(new Print(), new Computer(), new User());

    public static void main(String[] args) {
        runGame.startGame();
    }

}
