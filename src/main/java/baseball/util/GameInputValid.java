package baseball.util;


import java.util.HashSet;
import java.util.Set;

public class GameInputValid implements UserInputValid {

    @Override
    public void inputValid(String input) throws IllegalArgumentException {
        checkInputValue(input);
    }

    private void checkInputValue(String input) throws IllegalArgumentException {
        if (!isNumeric(input) || !isValidRange(input) || isValidZeroValue(input)
                || isValidDuplicateValue(input)) {
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

    private boolean isValidDuplicateValue(String input) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!uniqueChars.add(c)) {
                return true;
            }
        }
        return false;
    }
}
