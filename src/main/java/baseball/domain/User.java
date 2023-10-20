package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private List<Integer> userBaseballNumber = new ArrayList<>();

    public List<Integer> getUserBasebsallNumber() {
        return userBaseballNumber;
    }

    public void setUserBasebsallNumber(String input) {
        userBaseballNumber = validateInput(input);
    }

    private List<Integer> validateInput(String input) {
        validateDuplicated(input);
        validateLength(input);
        return validtaeNumeric(input);
    }

    private void validateLength(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException();
    }

    private void validateDuplicated(String input) {
        if (input.length() != input.chars().distinct().count())
            throw new IllegalArgumentException();
    }

    private List<Integer> validtaeNumeric(String input) {
        final String REGEX = "[1-9]+";
        if (input.matches(REGEX)) {
            return Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
