package baseball.utils;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final String INT_SEPARATOR = "";

    private Converter() {}

    public static List<Integer> convertIntToList(int number) {
        return Arrays.stream(String.valueOf(number).split(INT_SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }
}
