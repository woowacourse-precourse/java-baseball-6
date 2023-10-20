package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parseToIntegerList(String input) {
        return input.chars()
                .mapToObj(c -> Character.getNumericValue((char) c))
                .collect(Collectors.toList());
    }
}
