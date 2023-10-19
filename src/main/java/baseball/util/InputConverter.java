package baseball.util;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public final class InputConverter {

    public static List<Integer> splitToInt(String format, String input) {
        return Stream.of(input.split(format))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }

}
