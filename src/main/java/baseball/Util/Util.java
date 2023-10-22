package baseball.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Util {
    public static boolean isLengthThree(String input) {
        return input.length() == 3;
    }

    public static boolean isAllPositiveInteger(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUniqueCharacter(String input) {
        Set<Character> check = new HashSet<>();
        for (Character c : input.toCharArray()) {
            if (check.contains(c)) {
                return false;
            }
            check.add(c);
        }
        return true;
    }

    public static boolean isOneOrTwo(String input) {
        return input.equals("1") || input.equals("2");
    }

    public static List<Integer> parseStringToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();
        for (char c : input.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
        return list;
    }
}
