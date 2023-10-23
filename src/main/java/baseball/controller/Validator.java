package baseball.controller;

public class Validator {

    public static boolean validateInputIsNumber(String input) {
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i) || Character.getNumericValue(i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateInputLength(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }
    
}
