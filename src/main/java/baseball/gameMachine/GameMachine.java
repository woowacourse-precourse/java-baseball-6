package baseball.gameMachine;

import baseball.game.Game;

public interface GameMachine {

    void runGame(Game game);
    boolean askForReGame();
    void printText(String text);
    String getInput();
}
