package baseball;

public class InputValidator {

    public static void validateInputAnswer(String inputAnswer) {
        if (!inputAnswer.matches(InputValidateRegex.GAME_NUMBER_REGEX.toString())) {
            throw new InvalidAnswerInputException();
        }
    }

    public static void validateRetryInput(String retryInput) {
        if (!retryInput.matches(InputValidateRegex.RETRY_INPUT_REGEX.toString())) {
            throw new InvalidRetryInputException();
        }
    }
}
