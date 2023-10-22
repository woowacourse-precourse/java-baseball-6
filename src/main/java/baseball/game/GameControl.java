package baseball.game;

import baseball.print.PrintMessage;

public class GameControl {
    boolean gameState = false;
    PrintMessage printer = new PrintMessage();
    GamePlaying newGame = new GamePlaying();

    public void gameStart() {
        gameState = true;
        printer.printStartMessage();

        while(gameState) {
            gameState = newGame.playGame();
        }
    }
}
