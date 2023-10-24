package baseball.ui;

import static baseball.global.constant.OutputMessage.*;

public class OutputView {

    public void printGameStart() {
        println(GAME_START_MEESAGE);
    }

    public void printInputNumber() {
        print(INPUT_NUMBER_MESSAGE);
    }

    public void printGameEnd() {
        println(GAME_END_MESSAGE);
    }

    public void printGameRestart() {
        println(GAME_RESTART_MESSAGE);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    public void printGameFinish() {
        println(THREE_STRIKE_MESSAGE);
        printGameEnd();
    }

    public void printGameResult(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            print(NOTHING_ON_STRIKE);
        }

        StringBuilder builder = new StringBuilder();
        if (ball > 0) {
            builder.append(String.format("%d볼", ball));
            if (strike > 0) {
                builder.append(String.format(" %d스트라이크", strike));
            }
        } else {
            if (strike > 0) {
                builder.append(String.format("%d스트라이크", strike));
            }
        }
        println(builder.toString());
    }
}
