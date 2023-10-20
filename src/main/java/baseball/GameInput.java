package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class GameInput {
    public GameInput() {
    }

    public List<Integer> UserInputGuessNumber() {
        String userGuessNumString = Console.readLine();
        // need exception handler
        return intStringToList(userGuessNumString);
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
