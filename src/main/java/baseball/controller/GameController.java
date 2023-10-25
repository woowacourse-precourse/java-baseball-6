package baseball.controller;

import baseball.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    final int SIZE = 3;
    final int START_NUM = 1;
    final int END_NUM = 9;
    final int REPLAY = 1;
    final int GAME_OVER = 2;

    GameService gameService = new GameService();

    public void start() {
        setGame();
        startGame();
        endGame();
        askReplay();
    }

    private void setGame() {
        gameService.setGame(SIZE, START_NUM, END_NUM);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        OutputView.finishMessage();
    }

    private int getInputNum() throws IllegalArgumentException {
        int inputNum = Integer.parseInt(Console.readLine());

        if (inputNum == 0 || inputNum > GAME_OVER) {
            throw new IllegalArgumentException();
        }
        return inputNum;
    }

    private void askReplay() throws IllegalArgumentException {
        InputView.replayMessage();
        if (getInputNum() == REPLAY) {
            start();
        }
    }
}


