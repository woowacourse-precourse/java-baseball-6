package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        validateSize(userNumber);
        validateContainZero(userNumber);
        validateDuplicate(userNumber);
        this.userNumber = userNumber;
    }

    private void validateSize(List<Integer> userNumber) {
        if (userNumber.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void validateContainZero(List<Integer> userNumber) {
        if (userNumber.contains(0)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> userNumber) {
        Set checkDuplication = new HashSet();
        for (int i = 0; i < userNumber.size(); i++) {
            checkDuplication.add(userNumber.get(i));
        }
        if (checkDuplication.size() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
