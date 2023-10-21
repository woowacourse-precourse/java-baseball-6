package baseball.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private static final String EMPTY_STRING = "";

    private Converter() {
    }

    public static int convertStringToInt(final String string) {
        return Integer.parseInt(string);
    }

    public static List<Integer> convertStringToIntegerList(final String string) {
        return Arrays.stream(string.split(EMPTY_STRING))
                .map(Integer::parseInt)
                .toList();
    }

    public static String convertIntegerListToString(final List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(EMPTY_STRING));
    }
}
