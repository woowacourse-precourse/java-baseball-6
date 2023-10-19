package baseball;

public class Validator {

    private static final Validator instance = new Validator();

    private Validator() {
    }

    public static Validator getInstance() {
        return instance;
    }

    public static boolean isValidNumber(String input) {
        String[] digits = input.split("");
        Character ch = '1';

        return false;
    }

    public static void validateInput(String input) {
        if (!validateInputDigit(input)) {
            throw new IllegalStateException();
        }

        if (!validateInputRange(input)) {
            throw new IllegalStateException();
        }
    }

    private static boolean validateInputRange(String input) {
        return input.length() == Const.NUMBER_LENGTH;
    }

    private static boolean validateInputDigit(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }
    }
}
