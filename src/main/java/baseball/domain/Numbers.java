package baseball.domain;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(int numberOfDigitsInAnswer, List<Integer> numbers) {
        if (numbers.size() != numberOfDigitsInAnswer) {
            throw new IllegalArgumentException("Error: numbers 의 자리수가 올바르지 않습니다.");
        }
        this.numbers = numbers;
    }

    private int getIndexByNumber(int number) {
        return numbers.indexOf(number);
    }

    private int len() {
        return numbers.size();
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
        return "Numbers{" +
                "numbers=" + numbers +
                '}';
    }
}
