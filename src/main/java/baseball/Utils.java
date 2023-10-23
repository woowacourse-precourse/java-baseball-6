package baseball;

import java.util.List;

public class Utils {

    public static List<Integer> stringToIntList(final String str) {
        return str.chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
    }
}
