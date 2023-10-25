package baseball;

public class Computer {
    int firstNumber;
    int secondNumber;
    int thirdNumber;

    public Computer(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    int createNumber(int firstNumber, int secondNumber, int thirdNumber) {
        return firstNumber * 100 + secondNumber * 10 + thirdNumber;
    }

}
