package baseball.util;

public class ValidationUtils {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public static boolean validNumber(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
}
