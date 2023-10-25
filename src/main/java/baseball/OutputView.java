package baseball;

import static baseball.messageConstant.MessageConstant.*;

public class OutputView {
    public void printRequestInputNumberMessage() {
        System.out.print(REQUEST_INPUT_NUMBER_MESSAGE);
    }

    public void printStrikeBallCountMessage(int strike, int ball) {
        if (strike > 0 && ball > 0) System.out.println(ball + BALL + " " + strike + STRIKE);
        if (strike == 0 && ball > 0) System.out.println(ball + BALL);
        if (strike > 0 && ball == 0) System.out.println(strike + STRIKE);
        if (strike == 0 && ball == 0) System.out.println(NOTHING);
    }

    public void printBaseBallGameEndMessage() {
        System.out.println(BASE_BALL_GAME_END_MESSAGE);
    }

    public void printRetryInputNumberMessage() {
        System.out.println(RETRY_INPUT_NUMBER_MESSAGE);
    }
}