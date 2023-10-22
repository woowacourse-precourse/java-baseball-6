package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> stringToIntegerList(String string) {
        String[] stringArray;
        int integer;
        List<Integer> integerList = new ArrayList<>();

        stringArray = string.split("");
        for (int i = 0; i < stringArray.length; i++) {
            integer = Integer.valueOf(stringArray[i]);
            if (integerList.contains(integer)) {
                throw new IllegalArgumentException();
            }
            integerList.add(integer);
        }
        return integerList;
    }
}
