package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumber {

    private final List<Integer> computerNumber;

    public ComputerNumber(List<Integer> computerNumber) {
        validateSize(computerNumber);
        validateRange(computerNumber);
        validateDuplicate(computerNumber);
        this.computerNumber = computerNumber;
    }

    private void validateSize(List<Integer> computerNumber) {
        if (computerNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> computerNumber) {
        for (int i = 0; i < computerNumber.size(); i++) {
            if ((computerNumber.get(i) < 1) || (computerNumber.get(i) > 9)) {
                throw new IllegalArgumentException();
            }
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
