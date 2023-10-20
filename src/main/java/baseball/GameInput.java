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
        for (int i = 0; i < 3; i++) {
            intList.add(i, numberInt % 10);
            numberInt /= 10;
        }
        return intList;
    }
}
