package baseball.view;

import static baseball.consts.MessageConst.INPUT_RESTART_NUMBER;
import static baseball.consts.MessageConst.INPUT_USER_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputUserNum() {
        System.out.print(INPUT_USER_NUMBER);
        return Console.readLine();
    }

    public static String inputRestart() {
        System.out.println(INPUT_RESTART_NUMBER);
        return Console.readLine();
    }
}
