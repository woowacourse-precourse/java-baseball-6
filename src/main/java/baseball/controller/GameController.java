package baseball.controller;

import baseball.Service.GameService;

public class GameController {
    private static final int SIZE = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int RETRY_TRUE = 1;
    private static final int RETRY_FALSE = 2;
    GameService service = new GameService();

    public void run() {
        setGame();
        playGame();
        requestRetry();
    }

    private void requestRetry() {
        int request = service.requestRetry();
        if (request == RETRY_TRUE) {
            run();
        }
        if (request == 0 || request > RETRY_FALSE) {
            throw new IllegalArgumentException();
        }

    }

    private void playGame() {
        service.playGame(SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }

    private void setGame() {
        service.setGame(SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }
}
