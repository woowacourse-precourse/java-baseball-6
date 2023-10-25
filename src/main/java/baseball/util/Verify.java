package baseball.util;

public class Verify {
    public static final char FIRST_LIMIT = '1';
    public static final char LAST_LIMIT = '9';
    public static final char RESTART = '1';
    public static final char STOP = '2';
    public static void verifyNumber(String number) throws IllegalArgumentException {
        if(number.length()!=3)
            throw new IllegalArgumentException();
        if(number.charAt(0) < FIRST_LIMIT && number.charAt(0) > LAST_LIMIT )
            throw new IllegalArgumentException();
        if(number.charAt(1) < FIRST_LIMIT && number.charAt(1) > LAST_LIMIT )
            throw new IllegalArgumentException();
        if(number.charAt(2) < FIRST_LIMIT && number.charAt(2) > LAST_LIMIT )
            throw new IllegalArgumentException();
    }

    public static void verifyRestartValue(String number) throws IllegalArgumentException {
        if(number.charAt(0) < RESTART && number.charAt(0) > STOP)
            throw new IllegalArgumentException();
    }
}
