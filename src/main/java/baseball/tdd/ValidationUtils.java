package baseball.tdd;

public class ValidationUtils {
    private static final int MAX_NO = 10;
    private static final int MIN_NO = 1;

    public static boolean validNo(final int no) {
        return no < MAX_NO && no >= MIN_NO;
    }
}
