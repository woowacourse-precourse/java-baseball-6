package baseball.io.validator;

public class BaseballInputValidator extends InputValidator {
    @Override
    void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
    }
}
