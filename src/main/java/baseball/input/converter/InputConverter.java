package baseball.input.converter;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {
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
