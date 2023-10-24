package baseball.baseballV2.system.util;

import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<Character> StringToCharList(String input) {
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());
    }
}
