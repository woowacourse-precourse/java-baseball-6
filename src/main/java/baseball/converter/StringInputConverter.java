package baseball.converter;

public class StringInputConverter {

    public static int toInt(final String input) {
        return Integer.parseInt(input);
    }

    public static String[] toArray(final String input) {
        return input.split("");
    }
}
