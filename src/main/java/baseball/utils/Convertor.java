package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    public static String listToString(List<Integer> list) {
        String result = list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return result;
    }
}
