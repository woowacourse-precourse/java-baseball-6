package baseball;

public class InputValidator {
    private static InputValidator instance;

    private InputValidator() {

    }

    public static InputValidator getInstance() {
        if (instance == null) {
            instance = new InputValidator();
        }
        return instance;
    }

    // validate 3-digit
    public void validateThreeDigit(int inputNumber) {
        if (inputNumber < 100 || inputNumber > 999) {
            throw new IllegalArgumentException("Input must be 3-digit");
        }
    }

    public void validateEndInput(int inputNumber) {
        if (inputNumber != 1 && inputNumber != 2) {
            throw new IllegalArgumentException("Input must be either 1 or 2");
        }
    }

}
