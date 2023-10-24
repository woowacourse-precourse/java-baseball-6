package baseball.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {
    /**
     * number = 123
     * return = [1, 2, 3]
     */
    public static List<Integer> parseDigits(int number) {
        List<Integer> result = new ArrayList<>();

        int tmpNumber = number;

        while (tmpNumber > 0) {
            result.add(tmpNumber % 10);
            tmpNumber = tmpNumber / 10;
        }

        Collections.reverse(result);

        return result;
    }

    /**
     * list = [1, 2, 3]
     * return = 123
     */
    public static int listToInt(List<Integer> integers) {
        int result = 0;

        for (int i=0; i<integers.size(); i++) {
            result = result * 10 + integers.get(i);
        }

        return result;
    }

}
