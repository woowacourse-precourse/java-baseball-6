package baseball;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    private NumberParser() {}

    public static List<Integer> parseIntegerList(String numberString) {
        List<Integer> parsedNumbers = new ArrayList<>();
        validateIntString(numberString);
        for (int i = 0; i < numberString.length(); i++) {
            char ch = numberString.charAt(i);
            parsedNumbers.add(parseIntCharacter(ch));
        }
        return parsedNumbers;
    }

    public static int parseSingleDigitNumber(String numberString) {
        validateIntString(numberString);
        if (numberString.length() != 1) {
            throw new IllegalArgumentException("문자열 길이가 올바르지 않습니다.");
        }
        return Integer.parseInt(numberString);
    }

    private static int parseIntCharacter(char ch) {
        if (!('0' <= ch && ch <= '9')) {
            throw new IllegalArgumentException("숫자만 허용됩니다.");
        }
        return Character.getNumericValue(ch);
    }

    private static void validateIntString(String numberString) {
        if (numberString == null || numberString.isEmpty()) {
            throw new IllegalArgumentException("비어있지 않은 문자열이 입력되어야 합니다.");
        }
    }
}
