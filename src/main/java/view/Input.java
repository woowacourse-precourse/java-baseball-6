package view;

import camp.nextstep.edu.missionutils.Console;
import constants.MessageConstants;
import util.ErrorDetector;

public class Input {

    public static String readNumbers() {
        Output.printInputMessage(MessageConstants.INPUT_MESSAGE);
        String input = Console.readLine();
        ErrorDetector.throwIfNumbersInputInvalid(input);
        return input;
    }

    public static String readOption() {
        Output.printInputMessage(MessageConstants.RESTART_OR_FINISH_MESSAGE);
        String input = Console.readLine();
        ErrorDetector.throwIfOptionInputInvalid(input);
        return input;
    }
}
