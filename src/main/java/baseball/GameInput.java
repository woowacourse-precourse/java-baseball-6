package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameInput {
    public GameInput() {
    }

    public List<Integer> userInputGuessNumber() {
        String userGuessNumString = Console.readLine();
        // need exception handler
        return intStringToList(userGuessNumString);
    }

    public boolean userInputReGameSelection() {
        String userReGameSelection = Console.readLine();
        // need exception handler
        if (Integer.parseInt(userReGameSelection) == 1)
            return true; // start Game
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
