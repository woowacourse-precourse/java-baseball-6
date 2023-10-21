package baseball;

import java.util.Objects;

public class Answer {
    private int firstNumber;
    private int secondNumber;
    private int thirdNumber;

    public Answer(int firstNumber, int secondNumber, int thirdNumber) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Answer answer = (Answer) o;
        return firstNumber == answer.firstNumber && secondNumber == answer.secondNumber
                && thirdNumber == answer.thirdNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber, thirdNumber);
    }
}
