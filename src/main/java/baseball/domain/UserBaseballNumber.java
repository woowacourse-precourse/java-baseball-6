package baseball.domain;

import java.util.List;

public class UserBaseballNumber {

    private List<String> userValue;

    public UserBaseballNumber(List<String> userValue) {
        this.userValue = userValue;
    }

    private void validate(List<String> userValue) {
        if (userValue.size() != 3) {

        }
    }
}
