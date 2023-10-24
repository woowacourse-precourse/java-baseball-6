package baseball;

public class Validator {

    private static final int MAX_INPUT_LENGTH = 3;

    public static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void validInputLength(String input) {
        if (input.length() > MAX_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
