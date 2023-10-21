package baseball.model;

import java.util.List;

public class UserNumber {

    private final List<Integer> userNumber;

    public UserNumber(List<Integer> userNumber) {
        validate();
        this.userNumber = userNumber;
    }

    private void validate() {

    }
}
