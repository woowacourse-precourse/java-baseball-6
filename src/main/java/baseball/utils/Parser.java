package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> stringToList(String str) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i) - '0');
        }

        return result;
    }
}
