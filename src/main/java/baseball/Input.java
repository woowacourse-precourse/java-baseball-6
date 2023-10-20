package baseball;

import camp.nextstep.edu.missionutils.Console;
import constants.MessageConstants;

public class Input {

    public static String readNumbers() {
        Output.printMessage(MessageConstants.INPUT_MESSAGE);
        String input = Console.readLine();
        ErrorDetector.throwIfNumbersInputInvalid(input);
        return input;
    }

    public static String readOption() {
        Output.printMessage(MessageConstants.RESTART_OR_FINISH_MESSAGE);
        String input = Console.readLine();
        ErrorDetector.throwIfOptionInputInvalid(input);
        return input;
    }
}
