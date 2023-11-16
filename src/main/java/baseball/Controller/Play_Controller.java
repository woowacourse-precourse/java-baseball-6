package baseball.Controller;

import baseball.Service.Game_Service;
import baseball.View.RequestMessage;
import baseball.View.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Play_Controller {
    private static final int NUM_SIZE = 3;
    private static final int START = 1;
    private static final int END = 9;
    private static final int RETRY = 1;
    private static final int GAME_OVER = 2;

    Game_Service gameService = new Game_Service();

    public void runGame() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame(NUM_SIZE, START, END);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        SystemMessage.printGameOverMessage();
    }

    private void askRetry() throws IllegalArgumentException {
        RequestMessage.printRetryMessage();
        if (getInputNum() == RETRY) {
            runGame();
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