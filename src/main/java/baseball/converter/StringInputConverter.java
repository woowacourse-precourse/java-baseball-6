package baseball.converter;

import java.util.HashSet;
import java.util.Set;

public class StringInputConverter {

    public static int convertToInt(final String input) {
        return Integer.parseInt(input);
    }

    public static String[] convertToArray(final String input) {
        return input.split("");
    }

    public static Set<Character> convertToCharSet(final String input) {
        HashSet<Character> inputSet = new HashSet<>();

        for (char character : input.toCharArray()) {
            inputSet.add(character);
        }

        return inputSet;
    }
}
