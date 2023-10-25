package baseball.view;

import static baseball.utils.ViewMessage.GAME_START;
import static baseball.utils.ViewMessage.GAME_SUCCESS;
import static baseball.utils.ViewMessage.OUTPUT_BALL;
import static baseball.utils.ViewMessage.OUTPUT_BALL_AND_STRIKE;
import static baseball.utils.ViewMessage.OUTPUT_NOTHING;
import static baseball.utils.ViewMessage.OUTPUT_STRIKE;

public class OutputView {
    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printGameStartMessage() {
        System.out.print(GAME_START);
    }

    public void printGameSuccess() {
        System.out.print(GAME_SUCCESS);
    }

    public void printGameResult(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.printf(OUTPUT_BALL_AND_STRIKE, ball, strike);
            return;
        }
        if (ball > 0) {
            System.out.printf(OUTPUT_BALL, ball);
            return;
        }
        if (strike > 0) {
            System.out.printf(OUTPUT_STRIKE, strike);
            return;
        }
        System.out.print(OUTPUT_NOTHING);
    }
}