package baseball;

import java.util.ArrayList;
import java.util.List;
public class Converter {
    public static List<Integer> convert2Int(String value){
        List<Integer> intArray = new ArrayList<>(value.length());
        for (int i = 0; i < value.length(); i++) {
            int digit = Character.getNumericValue(value.charAt(i));
            intArray.add(digit);
        }

        return intArray;
    }
}
