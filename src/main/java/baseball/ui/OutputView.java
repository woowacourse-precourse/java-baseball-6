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
            println(NOTHING_MESSAGE);
            return;
        }

        StringBuilder builder = new StringBuilder();
        if (ball > 0) {
            builder.append(String.format(BALL_MESSAGE, ball));
            if (strike > 0) {
                builder.append(String.format(STRIKE_WITH_BALL_MESSAGE, strike));
            }
        } else {
            builder.append(String.format(STRIKE_WITHOUT_BALL_MESSAGE, strike));
        }
        println(builder.toString());
    }
}
