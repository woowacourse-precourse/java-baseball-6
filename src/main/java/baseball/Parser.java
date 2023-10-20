package baseball;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Integer> parse(String input) {
        int len = input.length();

        ArrayList<Integer> results = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            results.add(input.charAt(i) - '0');
        }

        return results;
    }
}
