package baseball.io.validator;

public class ProcessDecisionCommandValidator extends InputValidator {
    @Override
    void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
    }
}
