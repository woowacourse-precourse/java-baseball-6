package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(Character.getNumericValue(ch));
        }
        return numbers;
    }
}
