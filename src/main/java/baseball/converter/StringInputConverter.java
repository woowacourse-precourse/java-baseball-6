package baseball.converter;

public class StringInputConverter {

    public static int convertToInt(final String input) {
        return Integer.parseInt(input);
    }

    public static String[] convertToArray(final String input) {
        return input.split("");
    }
}
