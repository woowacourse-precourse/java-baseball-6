package baseball.validation;

public class Validation {

    public static boolean validInput(String input, String pattern) {
        if (!input.matches(pattern)) {
            return false;
        }
        return true;
    }
}
