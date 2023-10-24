package baseball.utils;


public class NumberUtils {

    private NumberUtils() {}

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
