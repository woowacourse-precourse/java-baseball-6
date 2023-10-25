package baseball.controller;

import baseball.service.GameService;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    final int SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame(SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        SystemMessage.printGameOverMessage();
    }

    private void askRetry() throws IllegalArgumentException {
        RequestInput.printRetryMessage();
        if (getInputNum() == RETRY) {
            run();
        }
    }

    private int getInputNum() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}

