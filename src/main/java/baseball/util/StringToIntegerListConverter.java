package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConverter {

    private StringToIntegerListConverter() {
    }

    public static List<Integer> StringToIntegerList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
