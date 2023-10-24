package baseball.domain;

import baseball.constant.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(int numberOfDigitsInAnswer, List<Integer> numbers) {
        checkNumberOfDigits(numberOfDigitsInAnswer, numbers);
        checkDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void checkNumberOfDigits(int numberOfDigits, List<Integer> numbers) {
        if (numberOfDigits != numbers.size()) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INVALID_DIGITS_AT_MAKING_NUMBERS.getMessage(),
                    numberOfDigits));
        }
    }

    private void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_AT_MAKING_NUMBERS.getMessage());
        }
    }

    public int calcNumOfBall(Numbers otherNumbers) {
        int numOfBall = 0;
        for (int i = 0; i < otherNumbers.numbers.size(); i++) {
            int numberOfComputerNumbers = numbers.get(i);
            int indexOfUserAnswer = otherNumbers.numbers.indexOf(numberOfComputerNumbers);
            if (indexOfUserAnswer != -1 && indexOfUserAnswer != i) {
                numOfBall += 1;
            }
        }
        return numOfBall;
    }

    public int calcNumOfStrike(Numbers otherNumbers) {
        int numOfStrike = 0;
        for (int i = 0; i < otherNumbers.numbers.size(); i++) {
            int numberOfComputerNumbers = numbers.get(i);
            int indexOfUserAnswer = otherNumbers.numbers.indexOf(numberOfComputerNumbers);
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
