package baseball;

import baseball.game.GameShell;

public class Application {
    public static void main(String[] args) {
        GameShell gameShell = new GameShell();
        gameShell.startGame();
    }
}
