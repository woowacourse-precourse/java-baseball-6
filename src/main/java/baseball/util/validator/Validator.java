package baseball.util.validator;

import baseball.exception.EmptyException;
import baseball.exception.ErrorMessage;
import baseball.exception.InvalidInputException;
import baseball.exception.NotNumericException;
import baseball.global.Const;
import baseball.util.parser.Parser;

public class Validator {
    private static final String NUMERIC_REGEX = "^[0-9]*$";

    public static void validateNumeric(String userInput) {
        if (isNotNumeric(userInput)) {
            throw NotNumericException.of(ErrorMessage.NONE_NUMERIC);
        }
    }

    private static boolean isNotNumeric(String userInput) {
        return !userInput.matches(NUMERIC_REGEX);
    }

    public static void validateEmpty(String userInput) {
        if (isEmptyValue(userInput)) {
            throw EmptyException.of(ErrorMessage.EMPTY_VALUE);
        }
    }

    private static boolean isEmptyValue(String userInput) {
        return userInput.strip().isEmpty();
    }

    public static void validateRestartInput(String input) {
        if (isNotOneOrTwo(input)) {
            throw InvalidInputException.of(ErrorMessage.NOT_REQUIRED_RESTART_INPUT);
        }
    }

    public static boolean isNotOneOrTwo(String input) {
        int userInput = Parser.parseToInt(input);
        return userInput == Const.RESTART_INPUT && userInput == Const.EXIT_INPUT;
    }
}
