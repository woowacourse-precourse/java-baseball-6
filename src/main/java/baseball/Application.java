package baseball;

import game.BaseballGame;
import game.Game;

public class Application {
    public static void main(String[] args) {
        Game baseballGame = new BaseballGame();
        baseballGame.executeGame();
    }
}
