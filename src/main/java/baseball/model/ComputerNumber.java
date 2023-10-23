package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    private static final int COMPUTER_NUMBER_SIZE = 3;
    private static final int COMPUTER_NUMBER_START_RANGE = 1;
    private static final int COMPUTER_NUMBER_END_RANGE = 9;

    private final List<Integer> computerNumber;

    public ComputerNumber(List<Integer> computerNumber) {
        validateSize(computerNumber);
        validateRange(computerNumber);
        validateDuplicate(computerNumber);
        this.computerNumber = computerNumber;
    }

    private void validateSize(List<Integer> computerNumber) {
        if (computerNumber.size() != COMPUTER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> computerNumber) {
        for (int number : computerNumber) {
            checkCorrectRange(number);
        }
    }

    private void checkCorrectRange(int number) {
        if (isCorrectRange(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isCorrectRange(int number) {
        return (number < COMPUTER_NUMBER_START_RANGE) || (number > COMPUTER_NUMBER_END_RANGE);
    }

    private void validateDuplicate(List<Integer> computerNumber) {
        Set checkDuplication = new HashSet();
        for (int number : computerNumber) {
            checkDuplication.add(number);
        }
        if (checkDuplication.size() != COMPUTER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
