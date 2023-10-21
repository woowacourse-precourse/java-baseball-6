package baseball;

public class UserInputValidation {
    private static final Integer GAME_NUMBER_SIZE = 3;
    private static final Integer RESTART_NUMBER_SIZE = 1;

    public boolean isValidGameNumber(String userInput) {
        if (userInput.length() != GAME_NUMBER_SIZE) {
            return false;
        }
        return isRangeGameNumber(userInput);
    }

    public boolean isValidRestartNumber(String userInput) {
        if (userInput.length() != RESTART_NUMBER_SIZE) {
            return false;
        }
        return isRangeRestartNumber(userInput);
    }

    public boolean isRangeGameNumber(String userInput) {
        for (int i = 0; i < GAME_NUMBER_SIZE; ++i) {
            char c = userInput.charAt(i);
            int number = Character.getNumericValue(c);
            if (number <= 0 || number > 9) {
                return false;
            }
        }
        return true;
    }

    public boolean isRangeRestartNumber(String userInput) {
        char c = userInput.charAt(0);
        int number = Character.getNumericValue(c);
        return number >= 0 && number <= 2;
    }
    
}
