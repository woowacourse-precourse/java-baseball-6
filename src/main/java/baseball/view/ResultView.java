package baseball.view;

import static baseball.model.MsgConst.BALL;
import static baseball.model.MsgConst.NOTHING;
import static baseball.model.MsgConst.STRIKE;
import static baseball.model.NumConst.FULL_STRIKE;

import baseball.Baseball;


public class ResultView {

    public static void givingHint(int ball, int strike) {
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
            Baseball.restartOrExit();
        }


    }

}
