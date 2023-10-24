package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringNumToIntegerNumListParser {
    public static List<Integer> stringNumToIntegerNumListParser(String numberTypeOfString) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < numberTypeOfString.length(); i++) {
            numberList.add(numberTypeOfString.charAt(i) - '0');
        }
        return numberList;
    }
}