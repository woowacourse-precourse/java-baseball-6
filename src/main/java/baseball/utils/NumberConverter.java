package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class NumberConverter {
    public static List<Integer> stringToNumber(String value) {
        List<Integer> numbers = new ArrayList<>();
        for (char number : value.toCharArray()) {
            numbers.add(number - '0');
        }
        return numbers;
    }
}
