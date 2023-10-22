package baseball.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private static final String SEPARATOR = "";

    private Converter() {
    }

    public static List<Integer> convertStringToIntegerList(final String string) {
        return Arrays.stream(string.split(SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }
}
