package baseball.utils;

public class InputValidator {
    public boolean isValidNumbersInput(String input) {
        return input.matches("[1-9]{3}") && !input.matches(".*(.)\\1.*");
    }

    public boolean isValidFinishInput(String input) {
        return input.equals(String.valueOf(Constants.RETRY)) || input.equals(String.valueOf(Constants.EXIT));
    }
}
