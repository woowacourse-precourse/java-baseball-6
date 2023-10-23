package baseball.domain.number;

import baseball.exception.number.NumberOutOfRangeException;

public class Number {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 9;
    private int firstNumber;

    private int secondNumber;

    private int thirdNumber;

    public Number(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public static Number from(int firstNumber, int secondNumber, int thirdNumber){
        checkNumberRange(firstNumber);
        checkNumberRange(secondNumber);
        checkNumberRange(thirdNumber);
        return new Number(firstNumber, secondNumber, thirdNumber);
    }
    private static void checkNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new NumberOutOfRangeException();
        }
    }
}
