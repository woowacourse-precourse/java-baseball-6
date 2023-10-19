package baseball.controller;

public class ValidateController {
    private final String numbers = "123456789";
    public boolean validateInputString(String input, Integer length) {
        if (input.length() != length) return false;

        for (String inputAtOne : input.split("")) {
            if (numbers.indexOf(inputAtOne) == -1) {
                return false;
            }
        }

        return true;
    }
}
