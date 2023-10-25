package baseball.domain;


import baseball.policy.ValidationPolicy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballUser implements User {

    private ValidationPolicy userValidationPolicy;
    private List<Integer> numbers;

    public BaseballUser(ValidationPolicy userValidationPolicy) {
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
        userValidationPolicy.isCorrectLength(userInput);
        userValidationPolicy.isNumericString(userInput);
        userValidationPolicy.hasNoZero(userInput);
    }
}
