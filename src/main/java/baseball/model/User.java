package baseball.model;

import baseball.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private List<Integer> userNumber;

    public User(String userNumber) {
        Validator.validateUserNumber(userNumber);
        this.userNumber = changeStringToList(userNumber);
    }

    private List<Integer> changeStringToList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
