package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Convertor {

    public static List<Integer> convertStringToList(String input) {
        List<Integer> list = new ArrayList<>();
        String[] split = input.split("");
        for (String s : split) {
            int digit = Integer.parseInt(s);
            list.add(digit);
        }
        return list;
    }
}
