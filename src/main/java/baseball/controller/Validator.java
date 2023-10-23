package baseball.controller;

public class Validator {

    public static boolean validateInputIsNumber(String input) {
        for (char i : input.toCharArray()) {
            if (!Character.isDigit(i)) {
                return false;
            }
        }
        return true;
    }

}
