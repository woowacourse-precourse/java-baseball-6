package baseball;

public class InputValidatorController {

    public void validateThreeDigitNumber(int num) {
        if (num < 100 || 999 < num) {
            throw new IllegalArgumentException("input number must be three digit number.");
        }
    }

    public void validateGameProgressNumber(int num) {
        if (num != 1 && num != 2) {
            throw new IllegalArgumentException("input number must be 1 or 2.");
        }
    }
}
