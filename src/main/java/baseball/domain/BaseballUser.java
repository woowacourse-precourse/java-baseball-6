package baseball.domain;

import baseball.policy.UserValidationPolicy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballUser implements User {

    private UserValidationPolicy userValidationPolicy;
    private List<Integer> numbers;

    public BaseballUser(UserValidationPolicy userValidationPolicy) {
        this.userValidationPolicy = userValidationPolicy;
    }

    public void setNumbers(String userInput) {

        validationUserInput(userInput);

        this.numbers = Stream.
                of(String.valueOf(userInput).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validationUserInput(String userInput) {
        userValidationPolicy.isNullOrEmpty(userInput);
        userValidationPolicy.hasNoDuplicateNumber(userInput);
        userValidationPolicy.isCorrectLength(userInput, 3);
        userValidationPolicy.isNumericString(userInput);
        userValidationPolicy.hasNoZero(userInput);
    }
}
