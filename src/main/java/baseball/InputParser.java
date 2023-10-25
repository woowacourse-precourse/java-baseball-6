package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputParser {

    public static List<Integer> getUserNumbers(final String input, final int goal) {
        List<Integer> numbers = new ArrayList<>();
        InputParser.validate(input, goal);
        numbers = toIntegerList(input);
        return numbers;
    }

    public static List<Integer> toIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbers.add(input.charAt(i) - '0');
        }
        return numbers;
    }

    public static void validate(final String input, final int goal) throws IllegalArgumentException {
        digitCheck(input);
        lengthCheck(input.length(), goal);
        duplicateCheck(input);
    }

    public static void digitCheck(final String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("NOT A DIGIT");
            }
        }
    }

    public static void lengthCheck(final int length, int goal) throws IllegalArgumentException {
        if (length != goal) {
            throw new IllegalArgumentException("BAD INPUT");
        }
    }

    public static void duplicateCheck(String input) throws IllegalArgumentException {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (set.contains(c)) {
                throw new IllegalArgumentException("DUPLICATE NUMBER");
            }
            set.add(c);
        }
    }
}
