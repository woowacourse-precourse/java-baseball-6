package baseball.utils;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    private StringUtils() {}
    public static boolean hasDuplicateCharacters(String str) {
        return str.length() != str.chars().distinct().count();
    }

    public static List<Integer> toIntegerList(String str) {
        return str.chars()
                .mapToObj(Character::getNumericValue)
                .collect(Collectors.toList());
    }

}
