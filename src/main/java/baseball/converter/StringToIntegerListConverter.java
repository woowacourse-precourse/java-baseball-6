package baseball.converter;

import java.util.List;
import java.util.stream.Collectors;

public class StringToIntegerListConverter {

    public static List<Integer> StringToList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
