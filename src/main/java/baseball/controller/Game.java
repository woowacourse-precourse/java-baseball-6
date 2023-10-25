package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private boolean gameFlag = true;
    private static final String AGAIN = "1";
    private static final String STOP = "2";

    private final ComputerNumber computerNumber;

    private final Play play;

    public Game() {
        this.computerNumber = new ComputerNumber();
        this.play = new Play();
    }

    public void game() {
        while (gameFlag) {
            OutputView.gameStart();
            computerNumber.newComputerNumber();
            play.play(computerNumber);
            OutputView.gameFinish();
            checkAgainOrStop(InputView.againOrStopInput());
        }
    }

    private void checkAgainOrStop(String input) {
        if (input.equals(AGAIN)) {
            gameFlag = true;
            return;
        }

        if (input.equals(STOP)) {
            gameFlag = false;
            return;
        }

        throw new IllegalArgumentException("1(재시작)과 2(종료)중에 입력하세요.");
    }
}
