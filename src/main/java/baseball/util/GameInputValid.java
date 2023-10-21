package baseball.util;


public class GameInputValid implements UserInputValid {

    @Override
    public void inputValid(String input) throws IllegalArgumentException {
        compareInputType(input);
    }

    private void compareInputType(String input) throws IllegalArgumentException {
        if (!isNumeric(input) || !isValidRange(input) || isValidZeroValue(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumeric(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidRange(String input) {
        return input.length() == NumberConstants.LIMIT_NUMBERS_SIZE.getValue();
    }

    private boolean isValidZeroValue(String input) {
        return input.contains("0");
    }
}
