package baseball.gameutil.validate;

import baseball.gameutil.InputMod;
import baseball.message.MessageString;

public class ValidateInputFactory {

    private ValidateInputFactory() {
    }

    public static ValidateInput getValidateInput(InputMod mod) {
        return switch (mod) {
            case GAME -> ValidateInputGame.getInstance();
            case RERUN -> ValidateInputRerun.getInstance();
            default -> throw new IllegalArgumentException(MessageString.WRONG_RERUN_INPUT_ERROR_STRING);
        };
    }
}
