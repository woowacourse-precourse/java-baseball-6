package baseball.input;

import baseball.error.CheckRestartNumber;
import baseball.output.Message;
import camp.nextstep.edu.missionutils.Console;

public class RestartInput {
    public static final char RESTART_NUMBER = '1';

    public static boolean inputRestartNumber() {
        Message.printRestartMessage();
        String input;
        input = Console.readLine();
        CheckRestartNumber.checkLength(input);
        CheckRestartNumber.checkNumber(input);

        return input.charAt(0) == RESTART_NUMBER;
    }
}
