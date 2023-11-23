package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Integer> convertToIntegerList(String userInput) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            addDigitToIntegerList(c, integerList);
        }
        return integerList;
    }

    public static void addDigitToIntegerList(char c, List<Integer> integerList) {
        if (Character.isDigit(c)) {
            integerList.add(Character.getNumericValue(c));
        }
    }
}
