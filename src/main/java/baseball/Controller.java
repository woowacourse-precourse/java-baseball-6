package baseball;

import baseball.service.GameService;
import baseball.view.RequestData;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
    final static int SIZE = 3;
    final static int START = 1;
    final static int END = 9;
    final static int RETRY = 1;
    final static int GAME_OVER = 2;

    GameService gameservice = new GameService();

    public void run() {
        setGame();
        startGame();
        endGame();
        retryGame();
    }

    private void setGame() {
        gameservice.setGame(SIZE, START, END);
    }

    private void startGame() {
        gameservice.play();
    }

    private void endGame() {
        SystemMessage.printGameOver();
    }

    private void retryGame() {
        RequestData.printRetry();
        if (getInputNum() == RETRY) {
            run();
        }

    }

    private int getInputNum() {
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }
}
