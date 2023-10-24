package baseball.validation;

import static baseball.constants.CompareConstant.EXIT_NUMBER;
import static baseball.constants.CompareConstant.RESTART_NUMBER;
import static baseball.constants.ErrorMessage.WRONG_INPUT_MESSAGE;

public class ValidateRestartOrExitNumber {

    public static void validateRestartOrExitNumber(String restartOrExit) {
        if (!restartOrExit.equals(RESTART_NUMBER) && !restartOrExit.equals(EXIT_NUMBER)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }
}
