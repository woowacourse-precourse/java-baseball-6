package baseball.util;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

public class StringUtil {
    public static Set<Character> stringToSetOfChar(String s) {
        var chars = s.chars();
        var objChars = chars.mapToObj(c -> (char) c);
        return objChars.collect(toSet());
    }

    public static List<Character> stringToListOfChar(String s) {
        var chars = s.chars();
        var objChars = chars.mapToObj(c -> (char) c);
        return objChars.collect(toList());
    }

    public static List<Integer> digitStringToListOfInt(String s) {
        var charStream = stringToListOfChar(s).stream();
        var charStreamIntMapping = charStream.map(Character::getNumericValue);
        return charStreamIntMapping.collect(toList());
    }
}
