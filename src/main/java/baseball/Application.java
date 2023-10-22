package baseball;

import baseball.game.Print;
import baseball.game.RunGame;

public class Application {
    private static final RunGame runGame = new RunGame(new Print());


    public static void main(String[] args) {
        runGame.startGame();
    }

}
