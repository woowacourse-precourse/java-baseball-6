package baseball.io.validator;

public class ProcessDecisionCommandValidator extends InputValidator {
    @Override
    public void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
    }
}
