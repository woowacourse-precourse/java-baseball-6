package baseball.view;

import baseball.validation.NumberDuplicateValidator;
import baseball.validation.NumberFormatValidator;
import baseball.validation.NumberRangeValidator;
import baseball.validation.NumberSizeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static String inputPlayerNumber() {
        String input = Console.readLine();
        NumberFormatValidator.validate(input);
        NumberRangeValidator.validate(input);
        NumberDuplicateValidator.validate(input);
        NumberSizeValidator.validate(input);
        return input;
    }

    public static String inputRetryCommand() {
        return Console.readLine();
    }
}
