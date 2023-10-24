package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static List<Integer> parseStringToListOfInteger(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
