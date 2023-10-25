package baseball.module.view;

import static baseball.global.constant.GameMessage.FINISH_GAME;
import static baseball.global.constant.GameMessage.GAME_SCORE;
import static baseball.global.constant.GameMessage.INPUT_NUMBER;
import static baseball.global.constant.GameMessage.NOT_THING;
import static baseball.global.constant.GameMessage.SELECT_RESTART;
import static baseball.global.constant.GameMessage.START_GAME;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println(START_GAME);
    }

    public void printRequestInputMessage() {
        System.out.println(INPUT_NUMBER);
    }

    public void printGameFinishMessage() {
        System.out.println(FINISH_GAME);
    }

    public void printSelectRestartMessage() {
        System.out.println(SELECT_RESTART);
    }

    public void printGameScoreMessage(int strike, int ball) {
        if (strike > 0 || ball > 0) {
            System.out.println(String.format(GAME_SCORE, ball, strike));
            return;
        }
        System.out.println(NOT_THING);
    }
}