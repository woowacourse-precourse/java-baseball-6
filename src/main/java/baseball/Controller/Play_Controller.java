package baseball.Controller;

import baseball.Service.Game_Service;
import baseball.View.RequestMessage;
import baseball.View.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Play_Controller {
    final int SIZE = 3;
    final int START = 1;
    final int END = 9;
    final int RETRY = 1;
    final int GAME_OVER = 2;

    Game_Service gameService = new Game_Service();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame(SIZE, START, END);
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