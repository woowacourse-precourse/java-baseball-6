package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import static baseball.util.Constant.*;
import static baseball.util.Constant.OutputView.*;

public class OutputView {
    public int getHints(int cmd, int ball, int strike) {
        if (ball == RANGE_ZERO && strike == RANGE_ZERO) System.out.print(RESULT_NOTHING);
        if (ball != RANGE_ZERO) System.out.print(ball + RESULT_BALL + BLANK);
        if (strike != RANGE_ZERO) System.out.print(strike + RESULT_STRIKE);
        if(strike == RANGE_DIGIT) {
            System.out.println(END_MSG);
            System.out.println(RESTART_MSG);
            try{
                cmd = Integer.parseInt(Console.readLine());
                if(cmd !=CMD_RESTART && cmd !=CMD_QUIT) throw new IllegalArgumentException();
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return cmd;
    }
}
