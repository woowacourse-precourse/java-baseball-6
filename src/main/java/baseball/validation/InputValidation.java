package baseball.validation;

public class InputValidation {

    // isThreeDigits : 숫자가 3자리 양수인지 여부를 반환한다.
    public static Boolean isThreeDigits(Integer number) {
        return number < 1000 && number > 99;
    }

    // isIncludeZero : 입력에 0이 하나라도 있는지 여부를 반환한다.
    public static Boolean isIncludeZero(Integer number1, Integer number2, Integer number3) {
        return number1.equals(0) || number2.equals(0) || number3.equals(0);
    }

    // isUniqueNumbers : 숫자 3개가 서로 다른 숫자인지 검증한다. 서로 다른 숫자라면 True, 같은 숫자가 하나라도 있다면 False를 반환한다.
    public static Boolean isUniqueNumbers(Integer uniqueNumber1, Integer uniqueNumber2, Integer uniqueNumber3) {
        return !uniqueNumber1.equals(uniqueNumber2)
                && !uniqueNumber2.equals(uniqueNumber3)
                && !uniqueNumber3.equals(uniqueNumber1);
    }

}
