package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputConverter {

    public static List<Integer> convert(String player) {

        List<Integer> result = new ArrayList<>();

        for (char ch : player.toCharArray()) {
            result.add(Integer.parseInt(String.valueOf(ch)));
        }
        return result;
    }
}