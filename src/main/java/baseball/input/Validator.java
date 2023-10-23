package baseball.input;

public class Validator {
    public static boolean isValid(String input) {
        if (!NullValidator.isValid(input) && !LengthValidator.isValid(input) && !NumberValidator.isValid(input)) {
            return false;
        }
        return true;
    }
}
