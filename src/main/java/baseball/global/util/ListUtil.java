package baseball.global.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {

    public static List<Integer> converseIntegerToIntList(int value){
        String stringValue = Integer.toString(value);
        return stringValue.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

    public static int converseIntListToInteger(List<Integer> integerList){
        int value = 0;
        for (int element : integerList) {
            value = value * 10 + element;
        }
        return value;
    }
}
