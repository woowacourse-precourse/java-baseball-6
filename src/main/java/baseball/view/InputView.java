package baseball.view;

import static baseball.view.InputMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String readUserAnswer() {
        System.out.print(PLEASE_ENTER_THE_ANSWER);
        return readLine();
    }
}
