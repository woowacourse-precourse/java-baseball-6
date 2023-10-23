package baseball.controller;

public class InputValidator {

    public static final String printError = "잘못된 값입니다. 프로그램을 종료합니다.";

    public static void isNumberOneOrTwo(String number) {
        if(number.charAt(0) == '1' || number.charAt(0) == '2')
            return;
        else
            throw new IllegalArgumentException(printError);
    }
    public static void isThreeDigitNaturalNumber(String number) {
        if(number.charAt(0) == 0)
            throw new IllegalArgumentException(printError);
    }

    public static void isNumberSize(String number) {
        if(number.length() != 3)
            throw new IllegalArgumentException(printError);
    }



}
