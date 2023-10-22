package baseball.controller;

import baseball.service.GameService;
import baseball.view.SystemGameMessage;
import baseball.view.SystemInputMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    final int NUMBER_SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    final int GAME_RESTART = 1;
    final int GAME_OVER = 2;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRestart();
    }

    private void setGame() {
        gameService.setGame(NUMBER_SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        SystemGameMessage.printGameOverMessage();
    }

    private void askRestart() throws IllegalArgumentException {
        SystemInputMessage.printRestartMessage();
        if (getInputNumber() == GAME_RESTART) {
            run();
        }
    }

    private int getInputNumber() throws IllegalArgumentException {
        int inputNumber = Integer.parseInt(Console.readLine());
        if (inputNumber == 0 || inputNumber > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }
}
