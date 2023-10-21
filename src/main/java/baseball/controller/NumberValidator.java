package baseball.controller;

public class NumberValidator {
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String wrongNumberMessage = "세 자리 숫자가 아닙니다.";

    public void toValidateNumber(String inputNumber) {
        if (!isSameLength(inputNumber)){
            throw new IllegalArgumentException(wrongNumberMessage);
        }
    }

    public boolean isSameLength(String inputNumber) {
        return inputNumber.length() == BASEBALL_NUMBER_LENGTH;
    }
}