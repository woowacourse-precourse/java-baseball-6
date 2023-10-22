package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerListParser {

    public static List<Integer> parse(String s) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            result.add(s.charAt(i) - '0');
        }

        return result;
    }
}