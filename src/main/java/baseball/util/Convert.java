package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Convert {

    public static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> userNumber = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int inputNumber = Character.getNumericValue(input.charAt(i));
            userNumber.add(inputNumber);
        }
        return userNumber;
    }

    public static int convertStringToInteger(String input) {
        return Integer.parseInt(input);
    }
}
