package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class TypeConvertor {

    public static List<Integer> stringToIntergerList(String input) {
        return input.chars()
                .filter(Character::isDigit)
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }
}
