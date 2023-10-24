package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private List<Integer> parseUserInput(String userInput) {
        List<Integer> userNumbers = parseInputNumbers(userInput);
        return userNumbers;
    }

    private List<Integer> parseInputNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for (char digitChar : userInput.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            userNumbers.add(digit);
        }
        return userNumbers;
    }
}
