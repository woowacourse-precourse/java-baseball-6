package baseball.baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringConvertUtil {

    public static List<Integer> stringToIntList(String inputString) {
        List<Integer> integerList = new ArrayList<>();
        int length = inputString.length();

        for (int i = 0; i < length; i++) {
            char digit = inputString.charAt(i);

            if (Character.isDigit(digit)) {
                int num = Character.getNumericValue(digit);
                integerList.add(num);
            }
        }

        return integerList;
    }
}
