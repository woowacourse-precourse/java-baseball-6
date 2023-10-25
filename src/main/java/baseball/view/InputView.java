package baseball.view;

import static baseball.utils.ViewMessages.INPUT_NUMBER;
import static baseball.utils.ViewMessages.INPUT_RETRY_OR_QUIT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    public static String inputRetryOrQuit() {
        System.out.println(INPUT_RETRY_OR_QUIT);
        return Console.readLine();
    }
}
