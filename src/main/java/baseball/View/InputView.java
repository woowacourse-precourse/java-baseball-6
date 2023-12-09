package baseball.View;

import static baseball.Constants.GET_NUM_MESSAGE;
import static baseball.Controller.InputController.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String readAnswer() {
        System.out.print(GET_NUM_MESSAGE);
        String input = readLine();
        checkException(input);

        return input;
    }
}
