package baseball.gameutil.validate;

import baseball.Constant;
import baseball.message.MessageString;

public class ValidateInputGame extends ValidateInputCommon implements ValidateInput {

    private static ValidateInputGame INSTANCE;

    private ValidateInputGame() {
    }

    public static ValidateInputGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ValidateInputGame();
        }
        return INSTANCE;
    }

    @Override
    public String validate(String input) {
        if (!checkLength(input, Constant.NUMBER_LENGTH)) {
            throw new IllegalArgumentException(MessageString.GAME_LEN_ERROR_STRING);
        }
        if (!checkIsAllNumber(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        if (!checkBetween(input, Constant.NUMBER_MIN, Constant.NUMBER_MAX)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        if (!checkUnique(input)) {
            throw new IllegalArgumentException(MessageString.WRONG_GAME_INPUT_ERROR_STRING);
        }
        return input;
    }
}

