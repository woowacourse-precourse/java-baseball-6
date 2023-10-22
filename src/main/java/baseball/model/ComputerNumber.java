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
        for (int i = 0; i < COMPUTER_NUMBER_SIZE; i++) {
            if ((computerNumber.get(i) < COMPUTER_NUMBER_START_RANGE) ||
                    (computerNumber.get(i) > COMPUTER_NUMBER_END_RANGE)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> computerNumber) {
        Set checkDuplication = new HashSet();
        for (int i = 0; i < computerNumber.size(); i++) {
            checkDuplication.add(computerNumber.get(i));
        }
        if (checkDuplication.size() != COMPUTER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
