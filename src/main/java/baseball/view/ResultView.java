package baseball.view;

import static baseball.constant.MsgConstant.*;
import static baseball.constant.NumConstant.*;

import baseball.Baseball;

public class ResultView {

    private static final Baseball baseball = new Baseball();

    public static void givingResult(int ball, int strike) {
        StringBuilder answer = new StringBuilder("");
        answer.setLength(0);

        if (ball == 0 && strike == 0) {
            answer.append(NOTHING);
        }
        if (ball > 0) {
            answer.append(ball).append(BALL).append(" ");
        }
        if (strike > 0) {
            answer.append(strike).append(STRIKE);
        }
        System.out.println(answer);

        if (strike == FULL_STRIKE) {
            baseball.restartOrExit();
        }
    }
}
