package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final int NUMBER_LENGTH = 3;

    public static List<Integer> parseUserNumberStringToList(String userNumber) {
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < NUMBER_LENGTH; i++) {
            char number = userNumber.charAt(i);
            userNumbers.add(Character.getNumericValue(number));
        }
        return userNumbers;
    }

}
