package baseball;

import java.util.ArrayList;
import java.util.List;
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

    public List<Hint> getHintsWithUserPrediction(UserPrediction prediction){
        List<Hint> hints = new ArrayList<>();
        hints.add(getHintWithNumberAndOrder(prediction.getFirstNumber(), Order.FIRST));
        hints.add(getHintWithNumberAndOrder(prediction.getSecondNumber(), Order.SECOND));
        hints.add(getHintWithNumberAndOrder(prediction.getThirdNumber(), Order.THIRD));
        return hints;
    }

    private Hint getHintWithNumberAndOrder(int number, Order order){
        if(numAt(order) == number){
            return Hint.STRIKE;
        }
        if(contains(number)){
            return Hint.BALL;
        }
        else return Hint.NOTHING;
    }

    private int numAt(Order order){
        int numberOfOrder = order.getOrder();
        if (numberOfOrder == 1) return firstNumber;
        else if (numberOfOrder == 2) return secondNumber;
        else return thirdNumber;
    }

    private boolean contains(int number){
        return number == firstNumber || number == secondNumber || number == thirdNumber;
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
