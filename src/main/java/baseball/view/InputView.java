package baseball.view;

import static baseball.utils.ViewMessages.INPUT_NUMBER;
import static baseball.utils.ViewMessages.INPUT_RETRY_OR_QUIT;

import baseball.utils.IntegerConvertor;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String inputNumber() {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    public static int inputRetryOrQuit() {
        System.out.println(INPUT_RETRY_OR_QUIT);
        return IntegerConvertor.toInteger(Console.readLine());
    }
}
