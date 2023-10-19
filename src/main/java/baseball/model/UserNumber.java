package baseball.model;

import java.util.List;

public class UserNumber {
    private final List<Integer> number;

    public UserNumber(String number) {
        validate(number);
        this.number = StringToList(number);
    }

    private void validate(String number) {

    }

    private List<Integer> StringToList(String number) {
    }

}
