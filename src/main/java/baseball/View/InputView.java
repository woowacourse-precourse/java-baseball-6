package baseball.View;
import camp.nextstep.edu.missionutils.Console;

import static baseball.View.OutputView.printRetry;
import static baseball.View.OutputView.printStart;

public class InputView {

    public static String readGameNumber() {
        String input = Console.readLine();
        return input;
    }

    public static int readRetryNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
