package baseball.gameutil.validate;

import baseball.gameutil.InputMod;

public class ValidateInputFactory {

    private ValidateInputFactory() {
    }

    public static ValidateInput getValidateInput(InputMod mod) {
        if (mod == InputMod.GAME) {
            return new ValidateInputGame();
        }
        if (mod == InputMod.RERUN) {
            return new ValidateInputRerun();
        }
        throw new IllegalArgumentException("Wrong input length");
    }
}
