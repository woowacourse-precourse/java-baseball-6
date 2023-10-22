package baseball.game;

import baseball.print.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameControl {
    boolean gameState = false;
    PrintMessage printer = new PrintMessage();
    GamePlaying newGame = new GamePlaying();

    public void gameStart() {
        gameState = true;
        printer.printStartMessage();

        while(gameState) {
            gameState = newGame.playGame();
            isGameOver();
        }
    }

    private void isGameOver() {
        if (!gameState) {
            printer.printEndMessage();
            String str = Console.readLine();
            int n = Integer.parseInt(str);
            decideGame(n);
        }
    }

    private void decideGame(int n) {
        if (n == 1) {
            gameState = true;
        }
    }
}
