package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> stringToIntegerList(String string) {
        List<Integer> integerList = new ArrayList<>();
        String[] stringArray = string.split("");

        for (int i = 0; i < stringArray.length; i++) {
            int integer = Integer.valueOf(stringArray[i]);
            integerList.add(integer);
        }
        return integerList;
    }
}
