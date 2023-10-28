package baseball;

import baseball.controller.PlayGame;

public class Application {
    public static void main(String[] args) {

        PlayGame playGame = new PlayGame();

        playGame.startGame();
    }

}
