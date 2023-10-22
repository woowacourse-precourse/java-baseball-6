package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputHandler {
    public String readInput(){
        return readLine();
    }

    public List<Integer> convertInputToNumbers(String userInput) {
        List<Integer> userNumbers = new ArrayList<>();
        for(char c : userInput.toCharArray())
            userNumbers.add(Character.getNumericValue(c));
        return userNumbers;
    }

    public Integer parseRestartChoice(String userInput){
        return Integer.parseInt(userInput);
    }
}
