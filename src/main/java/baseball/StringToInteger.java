package baseball;

import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
    static List<Integer> stringToIntegerList(String test) {
        List<Integer> input = new ArrayList<Integer>();
        for (int i = 0; i < test.length(); i++) {
            input.add(Integer.parseInt(String.valueOf(test.charAt(i))));
        }
        return input;
    }
}