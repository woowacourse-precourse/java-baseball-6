package baseball.validator;

import baseball.constant.InputValidateRegex;
import baseball.exception.InvalidAnswerInputException;
import baseball.exception.InvalidGameDecisionException;

public class InputValidator {

    public static void validateInputAnswer(String inputAnswer) {
        if (!inputAnswer.matches(InputValidateRegex.GAME_NUMBER_REGEX.toString())) {
            throw new InvalidAnswerInputException();
        }
    }

    public static void validateGameDecision(String inputGameDecision) {
        if (!inputGameDecision.matches(InputValidateRegex.GAME_DECISION_REGEX.toString())) {
            throw new InvalidGameDecisionException();
        }
    }
}
