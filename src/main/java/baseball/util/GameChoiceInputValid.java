package baseball.util;

public class GameChoiceInputValid implements UserInputValid {

    @Override
    public void inputValid(String input) {
        if (!isValidChoiceNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidChoiceNumber(String input) {
        return input.equals("1") || input.equals("2");
    }
}
