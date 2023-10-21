package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> parseIntegerList(String string) {
        List<Integer> separatedString = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            int number = string.charAt(i) - '0';
            separatedString.add(number);
        }

        return null;
    }
}
