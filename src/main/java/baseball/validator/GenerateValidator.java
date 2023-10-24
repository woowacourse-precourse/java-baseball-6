package baseball.validator;

import baseball.domain.BaseBall;
import baseball.exception.InvalidRangeException;
import baseball.exception.InvalidRestartInputException;

public class GenerateValidator {

    public void validateInputLength(int[] answer, int[] input) {
        if (answer.length != input.length) {
            throw new InvalidRestartInputException();
        }
    }

    public void checkMatch(int[] answer, int[] input, int index, BaseBall result) {
        if (answer[index] == input[index]) {
            result.addStrike();
        } else if (contains(input, answer[index])) {
            result.addBall();
        }
    }

    private boolean contains(int[] array, int element) {
        for (int number : array) {
            if (number == element) {
                return true;
            }
        }
        return false;
    }

    public void validateRange(int size, int start, int end) {
        if (end - start + 1 < size) {
            throw new InvalidRangeException();
        }
    }

    public boolean isDuplicate(int[] numbers, int currentIndex, int randomNumber) {
        for (int i = 0; i < currentIndex; i++) {
            if (numbers[i] == randomNumber) {
                return true;
            }
        }
        return false;
    }
}
