package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringtoList {
    public static List<Integer> changeStringtoList(String string) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            int currentInteger = (int) (string.charAt(i)) - '0';
            list.add(currentInteger);
        }

        return list;
    }
}
