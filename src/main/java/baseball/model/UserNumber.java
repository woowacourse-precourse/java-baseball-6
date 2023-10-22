package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {

    private static final int USER_NUMBER_SIZE = 3;
    private static final int USER_NUMBER_START_RANGE = 1;
    private static final int USER_NUMBER_END_RANGE = 9;

    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        validateSize(userNumber);
        validateRange(userNumber);
        validateDuplicate(userNumber);
        this.userNumber = userNumber;
    }

    private void validateSize(List<Integer> userNumber) {
        if (userNumber.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> userNumber) {
        for (int i = 0; i < userNumber.size(); i++) {
            if ((userNumber.get(i) < USER_NUMBER_START_RANGE) || (userNumber.get(i) > USER_NUMBER_END_RANGE)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> userNumber) {
        Set checkDuplication = new HashSet();
        for (int i = 0; i < userNumber.size(); i++) {
            checkDuplication.add(userNumber.get(i));
        }
        if (checkDuplication.size() != USER_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
