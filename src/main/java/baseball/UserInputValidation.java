package baseball;

public class UserInputValidation {
    private static final Integer GAME_NUMBER_SIZE = 3;

    public boolean isValidGameNumber(String userInput) {
        if (userInput.length() != GAME_NUMBER_SIZE) {
            return false;
        }
        return isNumeric(userInput);
    }

    public boolean isNumeric(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
