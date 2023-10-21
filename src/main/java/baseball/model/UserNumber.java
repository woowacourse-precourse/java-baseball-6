package baseball.model;

import java.util.List;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        validateSize(userNumber);
        validateContainZero(userNumber);
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
}
