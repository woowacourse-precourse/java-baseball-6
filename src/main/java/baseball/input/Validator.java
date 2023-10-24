package baseball.input;

public class Validator {
    public static boolean isValid(String input) {
        if (ZeroValidator.isValid(input) && LengthValidator.isValid(input) && NumberValidator.isValid(input)) {
            return true;
        }
        return false;
    }
}
