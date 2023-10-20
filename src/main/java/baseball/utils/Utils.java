package baseball.utils;

import java.util.List;

public class Utils {

    public static void convertArray(String input, List<Integer> paredArrayNumbers) {
        String[] split = input.split("");
        for (String s : split) {
            int paredInt = Integer.parseInt(s);
            paredArrayNumbers.add(paredInt);
        }
    }
}
