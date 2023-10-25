package baseball.util;

public class Verify {
    public static void verifyNumber(String number) throws IllegalArgumentException {
        if(number.length()!=3)
            throw new IllegalArgumentException();
        if(number.charAt(0) < '1' && number.charAt(0) > '9' )
            throw new IllegalArgumentException();
        if(number.charAt(1) < '1' && number.charAt(1) > '9' )
            throw new IllegalArgumentException();
        if(number.charAt(2) < '1' && number.charAt(2) > '9' )
            throw new IllegalArgumentException();
    }

    public static void verifyRestartValue(String number) throws IllegalArgumentException {
        if(number.charAt(0) < '1' && number.charAt(0) > '2')
            throw new IllegalArgumentException();
    }
}
