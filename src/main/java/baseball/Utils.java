package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {

    private Utils() {}

    public static String printAndInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

    public static List<Integer> stringArrToIntegerList(String input) {
        String[] inputStringArr = input.split("");
        List<Integer> list = new ArrayList<>();

        for (String str : inputStringArr) {
            list.add(Integer.parseInt(str));
        }

        return list;
    }



    public static boolean isValidSize(String input, int size) {
        return input.length() == size;
    }

    public static boolean isNaturalNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') return false;
        }
        return true;
    }

    public static boolean isNotDuplication(String input) {
        List<Character> list = new ArrayList<Character>();

        for (char c : input.toCharArray()) {
            list.add(c);
        }

        Set<Character> set = new HashSet<>(list);

        return list.size() == set.size();
    }
}
