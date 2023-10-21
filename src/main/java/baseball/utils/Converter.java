package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static final String INT_SEPARATOR = "";

    private Converter() {}

    public static List<Integer> convertIntToList(int number) {
        List<Integer> list = new ArrayList<>();
        for (String n : String.valueOf(number).split(INT_SEPARATOR)) {
            list.add(Integer.parseInt(n));
        }
        return list;
    }
}
