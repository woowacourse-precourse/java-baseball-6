package baseball.view;
import static baseball.enums.MessageEnum.*;

import baseball.enums.MessageEnum;
import camp.nextstep.edu.missionutils.Console;
public class RetryInputView {

    public static String input() {
        System.out.println(RESTART);
        return Console.readLine();
    }
}
