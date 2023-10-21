package baseball.util;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<Integer> stringToList(String number) {
        return number.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

}
