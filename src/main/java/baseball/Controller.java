package baseball;

import baseball.service.GameService;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {
        gameService.setGame(3, 1, 9);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame()  {
        SystemMessage.printGameOverMessage();
    }

    private void askRetry() throws IllegalArgumentException {
        RequestInput.printRetryMessage();
        if (getInputNum() == 1) {
            run();
        }

    }
    private int getInputNum() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum == 0 || inputNum > 2) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}

