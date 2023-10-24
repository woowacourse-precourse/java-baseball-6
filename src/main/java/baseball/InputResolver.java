package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputResolver {
    public List<Integer> stringToIntegerList(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            playerNumbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return playerNumbers;
    }
}
