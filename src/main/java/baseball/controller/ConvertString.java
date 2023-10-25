package baseball.controller;

import java.util.ArrayList;
import java.util.List;

public class ConvertString {
    // str to list
    public static List<Integer> strToList(String str) {
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp_char = str.charAt(i);
            int digit = Character.getNumericValue(tmp_char);
            intList.add(digit);
        }

        return intList;
    }
}
