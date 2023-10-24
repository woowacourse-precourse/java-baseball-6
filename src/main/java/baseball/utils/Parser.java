package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parseStringToList(String numbers) {
        return Arrays.stream(numbers.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
