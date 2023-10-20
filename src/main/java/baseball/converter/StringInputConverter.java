package baseball.converter;

public class StringInputConverter {

    public static int convertStringToInt(final String input) {
        return Integer.parseInt(input);
    }

    public static String[] convertStringToArray(final String input) {
        return input.split("");
    }
}
