package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.domain.GameSystem.NUMBER_LENGTH;

public class User {
    private List<Integer> userBaseballNumber = new ArrayList<>();

    public List<Integer> getUserBaseballNumber() {
        return userBaseballNumber;
    }

    public void setUserBaseballNumber(String input) {
        userBaseballNumber = validateInput(input);
    }

    private List<Integer> validateInput(String input) {
        validateDuplicated(input);
        validateLength(input);
        return validateNumeric(input);
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(String input) {
        if (input.length() != input.chars().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> validateNumeric(String input) {
        final String REGEX = "[1-9]+";
        if (input.matches(REGEX)) {
            return Arrays.stream(input.split(""))
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
        }

        throw new IllegalArgumentException();

    }
}
