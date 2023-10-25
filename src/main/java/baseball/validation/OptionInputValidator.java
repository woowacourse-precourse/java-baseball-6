package baseball.validation;

import static baseball.validation.ValidationUtility.throwIfContainsNonNumber;

import baseball.constants.MessageConstants;
import baseball.constants.StringConstants;
import baseball.view.Output;

public class OptionInputValidator implements Validator {

    @Override
    public void validate(String option) {
        throwIfContainsNonNumber(option);
        throwIfInvalidOptionInput(option);
    }

    private static void throwIfInvalidOptionInput(String option) {
        if (!option.equals(StringConstants.CONTINUE) && !option.equals(StringConstants.FINISH)) {
            Output.printErrorMessage(MessageConstants.INVALID_OPTION_INPUT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
