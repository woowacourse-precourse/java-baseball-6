package baseball.util;

import static java.util.regex.Pattern.matches;

import baseball.exception.consoleView.ConsoleInputCanNotChangeToIntException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private static final String EMPTY_STRING = "";
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private Converter() {
    }

    public static List<Integer> stringToIntegerList(final String string) {
        validateCanConvertToInt(string);
        return Arrays.stream(string.split(EMPTY_STRING))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateCanConvertToInt(final String string) {
        if (!matches(REGEXP_PATTERN_NUMBER, string)) {
            throw new ConsoleInputCanNotChangeToIntException(string);
        }
    }

    public static String integerListToString(final List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(EMPTY_STRING));
    }
}
