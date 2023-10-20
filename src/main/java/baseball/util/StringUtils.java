package baseball.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtils {
    public static Set<Character> stringToSetOfChar(String s) {
        var chars = s.chars();
        var objChars = chars.mapToObj(c -> (char) c);
        return objChars.collect(Collectors.toSet());
    }

    public static List<Character> stringToListOfChar(String s) {
        var chars = s.chars();
        var objChars = chars.mapToObj(c -> (char) c);
        return objChars.collect(Collectors.toList());
    }

    public static List<Integer> digitStringToListOfInt(String s) {
        var listOfChars = stringToListOfChar(s);
        var stream = listOfChars.stream();
        var mapToInt = stream.map(Character::getNumericValue);
        return mapToInt.collect(Collectors.toList());
    }
}
