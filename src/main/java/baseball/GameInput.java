package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {

    private final InputValidator inputValidator;

    public GameInput() {
        inputValidator = new InputValidator();
    }

    public UserGuessNumber userInputGuessNumber() {
        String userGuessNumberString = Console.readLine();
        inputValidator.isValidGuessNumber(userGuessNumberString);
        return new UserGuessNumber(userGuessNumberString);
    }

    public boolean userInputReGameSelection() {
        String userReGameOption = Console.readLine();
        inputValidator.isValidReGameOptionNumber(userReGameOption);
        if (Integer.parseInt(userReGameOption) == 1) {
            return true; // start Game
        }
        return false; // exit Game
    }
}
