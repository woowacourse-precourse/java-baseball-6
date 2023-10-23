package baseball.domain.number;

public class Number {
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
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("1~9 사이의 값만 입력하여야 합니다.");
        }
    }
}
