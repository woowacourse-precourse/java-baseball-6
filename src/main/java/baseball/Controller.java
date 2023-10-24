package baseball;

import baseball.Service.GameService;
import baseball.View.RequestMessageView;
import baseball.View.ResponseMessageView;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final int RETRY = 1;
    final int GAME_OVER =2;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame();
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() throws IllegalArgumentException {
        ResponseMessageView.gameOverPrint();
    }

    private void askRetry() throws IllegalArgumentException {
        RequestMessageView.requestRetryPrint();
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
