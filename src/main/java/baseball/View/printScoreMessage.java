package baseball.View;

import static baseball.dto.Result.*;

public class printScoreMessage {

    public void printMessage(int ball, int strike) {
        if (ball == 0 && strike != 0)
            System.out.println(strike + STRIKE_MESSAGE);
        if (ball != 0 && strike == 0)
            System.out.println(ball + BALL_MESSAGE);
        if (ball != 0 && strike != 0)
            System.out.println(ball + BALL_MESSAGE + strike + STRIKE_MESSAGE);
        if (ball == 0 && strike == 0)
            System.out.println(NO_CONUT_MESSAGE);
    }
    public static void printGameOverMessage() {
        System.out.println(SUCCESS_AND_EXIT_MESSAGE);
    }

}
