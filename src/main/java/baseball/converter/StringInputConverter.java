package baseball.converter;

import java.util.HashSet;
import java.util.Set;

public class StringInputConverter {

    public static int toInt(final String input) {
        return Integer.parseInt(input);
    }

    public static String[] toArray(final String input) {
        return input.split("");
    }

    public static Set<Character> toCharSet(final String input) {
        HashSet<Character> inputSet = new HashSet<>();

        for (char character : input.toCharArray()) {
            inputSet.add(character);
        }

        return inputSet;
    }
}
