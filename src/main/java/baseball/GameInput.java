package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameInput {

    InputValidator inputValidator;

    public GameInput() {
        inputValidator = new InputValidator();
    }

    public List<Integer> userInputGuessNumber() {
        String userGuessNumberString = Console.readLine();
        inputValidator.isValidGuessNumber(userGuessNumberString);
        return intStringToList(userGuessNumberString);
    }

    public boolean userInputReGameSelection() {
        String userReGameOption = Console.readLine();
        inputValidator.isValidReGameOptionNumber(userReGameOption);
        if (Integer.parseInt(userReGameOption) == 1) {
            return true; // start Game
        }
        return false; // exit Game
    }

    private List<Integer> intStringToList(String numberString) {
        int numberInt = Integer.parseInt(numberString);
        List<Integer> intList = new ArrayList<Integer>();
        while (numberInt > 0) {
            intList.add(0, numberInt % 10);
            numberInt /= 10;
        }
        return intList;
    }
}
