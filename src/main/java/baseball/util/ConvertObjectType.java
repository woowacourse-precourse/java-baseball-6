package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class ConvertObjectType {
    public static List<Integer> convertStringToList(String input) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char charAtPosition = input.charAt(i);
            int digit = Character.getNumericValue(charAtPosition);
            resultList.add(digit);
        }
        return resultList;
    }
}
