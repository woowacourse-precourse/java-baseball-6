package baseball.baseball.util;

import java.util.ArrayList;
import java.util.List;

import static baseball.baseball.model.constants.NOT_NUMBER_ERROR;

public class StringConvertUtil {

    public static List<Integer> stringToIntList(String inputString) {
        List<Integer> integerList = new ArrayList<>();
        int length = inputString.length();

        for (int i = 0; i < length; i++) {
            char digit = inputString.charAt(i);

            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException(NOT_NUMBER_ERROR);
            }

            int num = Character.getNumericValue(digit);
            integerList.add(num);
        }

        return integerList;
    }
}
