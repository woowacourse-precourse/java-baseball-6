package baseball.validation;

import static baseball.validation.ValidationUtility.throwIfContainsNonNumber;

import baseball.constants.MessageConstants;
import baseball.constants.NumberConstants;
import baseball.constants.StringConstants;
import baseball.view.Output;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersInputValidator implements Validator {

    @Override
    public void validate(String numbers) {
        throwIfContainsNonNumber(numbers);
        throwIfInvalidInputLength(numbers);
        throwIfContainsZero(numbers);
        throwIfContainsDuplicateNumbers(numbers);
    }

    private static void throwIfInvalidInputLength(String numbers) {
        if (numbers.length() != NumberConstants.MAX_BALL_SIZE) {
            Output.printErrorMessage(MessageConstants.INVALID_NUMBERS_INPUT_LENGTH_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfContainsZero(String numbers) {
        if (numbers.contains(StringConstants.ZERO_STRING)) {
            Output.printErrorMessage(MessageConstants.INVALID_NUMBERS_CONTAINS_ZERO);
            throw new IllegalArgumentException();
        }
    }

    private static void throwIfContainsDuplicateNumbers(String numbers) {
        Set<String> set = new HashSet<>(List.of(numbers.split(StringConstants.BLANK)));
        if (set.size() != NumberConstants.MAX_BALL_SIZE) {
            Output.printErrorMessage(MessageConstants.INVALID_NUMBERS_CONTAINS_DUPLICATE_NUMBER);
            throw new IllegalArgumentException();
        }
    }
}
