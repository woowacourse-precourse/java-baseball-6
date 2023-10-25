package baseball.validator;

import baseball.constant.InputValidateRegex;
import baseball.exception.InvalidNumberInputException;
import baseball.exception.InvalidGameDecisionException;

public class InputValidator {

    public static void validateInputNumber(String inputNumber) {
        if (!inputNumber.matches(InputValidateRegex.GAME_NUMBER_REGEX.toString())) {
            throw new InvalidNumberInputException();
        }
    }

    public static void validateInputGameDecision(String inputGameDecision) {
        if (!inputGameDecision.matches(InputValidateRegex.GAME_DECISION_REGEX.toString())) {
            throw new InvalidGameDecisionException();
        }
    }
}
