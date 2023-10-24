package baseball.view;

import static baseball.util.AppConstants.ASK_RESTART_MESSAGE;
import static baseball.util.AppConstants.INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputNumbers() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String restartGame() {
        System.out.println(ASK_RESTART_MESSAGE);
        return Console.readLine();
    }
}
