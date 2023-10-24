package baseball.validator;

public class InputValidator {

    public boolean isValidNumberInput(String input, int start, int end, int size) {
        String pattern = String.format("[%d-%d]{%d}", start, end, size);
        return input.matches(pattern);
    }

    public boolean isValidRestartOrExit(String input, int restart, int exit) {
        if (!isNumber(input)) {
            return false;
        }

        int inputValue = Integer.parseInt(input);
        return inputValue == restart || inputValue == exit;
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
