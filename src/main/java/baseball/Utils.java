package baseball;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    static List<Integer> stringToInt(String string) {
        List<Integer> integerList = new ArrayList<>();
        char[] tmp = string.toCharArray();
        for(char c: tmp) {
            integerList.add(Character.getNumericValue(c));
        }
        return integerList;
    }
}
