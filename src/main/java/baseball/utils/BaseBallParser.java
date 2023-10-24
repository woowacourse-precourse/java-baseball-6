package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class BaseBallParser {

    public static List<Integer> parse(final String input, final int size) throws IllegalArgumentException {
        List<Integer> result = new ArrayList<>();

        lengthCheck(input.length(), size);

        for (int i = 0; i < size; i++) {
            char c = input.charAt(i);

            isDigit(c);
            int number = toDigit(c);

            isDuplicate(result, number);
            result.add(number);
        }
        return result;
    }

    private static int toDigit(final char c) {
        return c - '0';
    }

    private static void lengthCheck(int a, int b) throws IllegalArgumentException {
        if (a != b) {
            throw new IllegalArgumentException("bad input!!!");
        }
    }

    private static void isDigit(final char c) throws IllegalArgumentException {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("not a number");
        }
    }

    private static void isDuplicate(List<Integer> numbers, int pick) throws IllegalArgumentException {
        if (numbers.contains(pick)) {
            throw new IllegalArgumentException("duplicate number");
        }
    }
}
