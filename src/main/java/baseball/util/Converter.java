package baseball.util;

import baseball.model.Number;
import java.util.List;

public class Converter {

    private static final String NON_NUMERIC_INPUT_MESSAGE = "숫자를 입력해주세요.";
    private static final String NUMERIC_PATTERN = "\\d+";

    private Converter() {
    }

    public static List<Number> convertStringToNumgerList(final String input) {
        validateInputIsNumeric(input);

        return input.chars()
                .mapToObj(number -> new Number(Character.getNumericValue(number)))
                .toList();
    }

    private static void validateInputIsNumeric(final String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }

    private static boolean isNumeric(final String input) {
        return input.matches(NUMERIC_PATTERN);
    }
}
