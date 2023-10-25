package baseball.view;

import baseball.constants.MessageConstants;
import baseball.validation.NumbersInputValidator;
import baseball.validation.OptionInputValidator;
import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static Validator validator;

    public static String readNumbers() {
        validator = new NumbersInputValidator();
        Output.printInputMessage(MessageConstants.INPUT_MESSAGE);
        String input = Console.readLine();
        validator.validate(input);
        return input;
    }

    public static String readOption() {
        validator = new OptionInputValidator();
        Output.printMessage(MessageConstants.RESTART_OR_FINISH_MESSAGE);
        String input = Console.readLine();
        validator.validate(input);
        return input;
    }
}
