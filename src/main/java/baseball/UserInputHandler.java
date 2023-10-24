package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    public String readUserInput() {
        return Console.readLine();
    }
    
    public List<Integer> parseStringNumbers(String userInput) throws IllegalArgumentException {
        List<Integer> userInputNumbers = new ArrayList<>();
        for (char digit : userInput.toCharArray()) {
            if (Character.isDigit(digit)) {
                userInputNumbers.add(Integer.parseInt(String.valueOf(digit)));
            }
        }
        return userInputNumbers;
    }
}
