package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private List<Integer> userNumber;

    public User(String userNumber) {
        validateUserNumber(userNumber);
        this.userNumber = changeStringToList(userNumber);
    }

    private List<Integer> changeStringToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateUserNumber(String input) {

    }
}
