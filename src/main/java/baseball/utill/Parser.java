package baseball.utill;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> parseInputToList(String input) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return userNumbers;
    }
}
