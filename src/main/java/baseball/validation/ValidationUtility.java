package baseball.validation;

import baseball.constants.MessageConstants;
import baseball.view.Output;

public class ValidationUtility {

    public static void throwIfContainsNonNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            Output.printErrorMessage(MessageConstants.INVALID_INPUT_ONLY_INTEGER_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

}
