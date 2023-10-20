package baseball.domain;

import java.util.LinkedList;
import java.util.List;

public class Numbers {
    private final int numberOfDigitsInAnswer;
    private final List<Integer> numbers;

    public Numbers(int numberOfDigitsInAnswer) {
        this.numberOfDigitsInAnswer = numberOfDigitsInAnswer;
        this.numbers = new LinkedList<>();
    }

    public Numbers(int numberOfDigitsInAnswer, List<Integer> numbers) {
        this.numberOfDigitsInAnswer = numberOfDigitsInAnswer;
        this.numbers = numbers;
    }

    public boolean isComplete() {
        return numbers.size() == numberOfDigitsInAnswer;
    }

    public void appendNumber(int number) {
        if (numbers.size() < numberOfDigitsInAnswer) {
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public int len() {
        return numbers.size();
    }

    public int getNumberOfDigitsInAnswer() {
        return numberOfDigitsInAnswer;
    }

    private int getIndexByNumber(int number) {
        return numbers.indexOf(number);
    }

    public int calcNumOfBall(Numbers otherNumbers) {
        int numOfBall = 0;
        for (int i = 0; i < otherNumbers.len(); i++) {
            int numberOfComputerNumbers = numbers.get(i);
            int indexOfUserAnswer = otherNumbers.getIndexByNumber(numberOfComputerNumbers);
            if (indexOfUserAnswer != -1 && indexOfUserAnswer != i) {
                numOfBall += 1;
            }
        }
        return numOfBall;
    }

    public int calcNumOfStrike(Numbers otherNumbers) {
        int numOfStrike = 0;
        for (int i = 0; i < otherNumbers.len(); i++) {
            int numberOfComputerNumbers = numbers.get(i);
            int indexOfUserAnswer = otherNumbers.getIndexByNumber(numberOfComputerNumbers);
            if (indexOfUserAnswer != -1 && indexOfUserAnswer == i) {
                numOfStrike += 1;
            }
        }
        return numOfStrike;
    }


    @Override
    public String toString() {
        return "Numbers{" + "numbers=" + numbers + '}';
    }
}
