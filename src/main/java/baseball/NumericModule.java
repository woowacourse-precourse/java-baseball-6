package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumericModule {

    private NumericModule() {
    }

    public static List<Integer> stringToIntegerList(String string) {
        List<Integer> numberList = new ArrayList<>();
        for (char ch : string.toCharArray()) {
            int number = Character.getNumericValue(ch);
            numberList.add(number);
        }
        return numberList;
    }

    public static boolean isNumeric(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
