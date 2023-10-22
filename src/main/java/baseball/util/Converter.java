package baseball.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    private static final String SEPARATOR = "";
    private static final String NON_NUMERIC_MESSAGE = "숫자를 입력해주세요.";
    private static final String NUMERIC_PATTERN = "\\d+";

    private Converter() {
    }

    public static List<Integer> convertStringToIntegerList(final String string) {
        validateInputIsNumeric(string);

        return Arrays.stream(string.split(SEPARATOR))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateInputIsNumeric(final String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(NON_NUMERIC_MESSAGE);
        }
    }

    private static boolean isNumeric(final String input) {
        return input.matches(NUMERIC_PATTERN);
    }
}
