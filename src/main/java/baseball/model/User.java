package baseball.model;

import baseball.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Numbers userNumber;

    public User(String userNumber) {
        Validator.validateUserNumber(userNumber);
        this.userNumber = changeStringToList(userNumber);
    }

    private Numbers changeStringToList(String input) {
        List<Integer> userNumberList = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(userNumberList);
    }

    public Numbers getUserNumber() {
        return userNumber;
    }
}
