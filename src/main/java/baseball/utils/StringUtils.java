package baseball.utils;

import java.util.List;

public class StringUtils {

    public static List<Integer> convertStringToIntegerList(String string) {
        return string.chars()
                .map(character -> character - '0')
                .boxed()
                .toList();
    }

}
