package baseball.validator;

import javax.lang.model.type.IntersectionType;

import static baseball.constant.Const.INPUT_ERROR_MESSAGE;
import static baseball.constant.Const.NOT_NUMERIC_ERROR_MESSAGE;

public class RestartInputValidator {
    public static void restartInputCondition(String input) {
        validateRange(input);
        validateNumeric(input);
    }

    public static void validateRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if(inputNumber != 1 && inputNumber != 2){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateNumeric(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }
}
