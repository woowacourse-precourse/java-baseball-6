package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    private final List<Integer> computerNumber;

    public ComputerNumber(List<Integer> computerNumber) {
        validateSize(computerNumber);
        validateContainZero(computerNumber);
        validateDuplicate(computerNumber);
        this.computerNumber = computerNumber;
    }

    private void validateSize(List<Integer> computerNumber) {
        if (computerNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContainZero(List<Integer> computerNumber) {
        if (computerNumber.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> computerNumber) {
        Set checkDuplication = new HashSet();
        for (int i = 0; i < computerNumber.size(); i++) {
            checkDuplication.add(computerNumber.get(i));
        }
        if (checkDuplication.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
