package baseball.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class Parser {

    private static int[] stringToIntArray(String string) {
        return Arrays.stream(string.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(stringToIntArray(string))
                .boxed()
                .collect(Collectors.toList());
    }
}
