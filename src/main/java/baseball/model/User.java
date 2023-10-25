package baseball.model;

import baseball.validator.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private static final String SPLIT_WORD_INTO_CHARS = "";
    private Numbers userNumber;

    public User(String input) {
        Validator.validateUserNumber(input);
        userNumber = changeStringToList(input);
    }

    private Numbers changeStringToList(String input) {
        List<Integer> numbers = Arrays.stream(input.split(SPLIT_WORD_INTO_CHARS))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Numbers(numbers);
    }

    public Numbers getUserNumber() {
        return userNumber;
    }
}
