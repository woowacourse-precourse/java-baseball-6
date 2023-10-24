package baseball.common;

import java.util.ArrayList;
import java.util.List;

public class StringToList {
    public static List<Integer> convert(String string) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < string.length(); ++i) {
            list.add(string.charAt(i) - '0');
        }
        return list;
    }
}
