package baseball.common;

public class StringToInteger {
    public static int convert(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
