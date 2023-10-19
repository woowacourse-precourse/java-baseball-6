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

    public static boolean validateInput(String input) {
        return validateInputRange(input) && validateInputDigit(input);
    }

    public static boolean validateInputRange(String input) {
        return input.length() == Const.NUMBER_LENGTH;
    }

    public static boolean validateInputDigit(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalStateException();
        }
    }
}
