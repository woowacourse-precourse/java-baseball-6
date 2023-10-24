package baseball.gameutil.validate;

import baseball.Constant;
import baseball.message.MessageString;

public class ValidateInputRerun extends ValidateInputCommon implements ValidateInput {

    private static ValidateInputRerun INSTANCE;

    private ValidateInputRerun() {
    }

    public static ValidateInputRerun getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ValidateInputRerun();
        }
        return INSTANCE;
    }

    @Override
    public String validate(String input) {
        if (!checkLength(input, Constant.RESTART_MODE_LENGTH)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        if (!checkIsAllNumber(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        if (!checkBetween(input, Constant.RESTART_RESTART, Constant.RESTART_END)) {
            throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        }
        return input;
    }
}
