package baseball.utils;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtils {
    public static Set<Character> stringToSetOfChar(String s) {
        var chars = s.chars();
        var objChars = chars.mapToObj(c -> (char)c);
        return objChars.collect(Collectors.toSet());
    }
}
