package baseball.view;

import static baseball.view.InputMessage.PLEASE_ENTER_THE_ANSWER;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String readUserAnswer() {
        System.out.print(PLEASE_ENTER_THE_ANSWER);
        return readLine();
    }
}
