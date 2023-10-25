package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertObjectType {
    public static List<Integer> convertStringToList(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
