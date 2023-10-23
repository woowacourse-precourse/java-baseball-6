package baseball.game.validate;

public class ValidateInputFactory {

    private ValidateInputFactory() {
    }

    public static ValidateInput getValidateInput(Integer MOD) {
        if (MOD == 3) {
            return new ValidateInputGame();
        }
        if (MOD == 1) {
            return new ValidateInputRerun();
        }
        throw new IllegalArgumentException("Wrong input length");
    }
}
