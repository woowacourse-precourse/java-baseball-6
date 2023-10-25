package baseball;

import baseball.game.SetOfGameFactory;
import baseball.game.TotalGame;

public class Application {
    public static void main(String[] args) {
        TotalGame totalGame = new TotalGame(new SetOfGameFactory());
        totalGame.play();
    }
}
