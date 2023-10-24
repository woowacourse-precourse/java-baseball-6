package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Integer> userNumbers = new ArrayList<>();

    public void askUserNumbers() {
        userNumbers.clear();

        String userInput = Console.readLine();
        for (char number : userInput.toCharArray()) {
            userNumbers.add(Character.getNumericValue(number));
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
