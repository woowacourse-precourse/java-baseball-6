package baseball.domain;

import baseball.policy.BaseballValidationPolicy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballUser implements User {

    private BaseballValidationPolicy baseballValidationPolicy;
    private List<Integer> numbers;

    public BaseballUser(BaseballValidationPolicy baseballValidationPolicy) {
        this.baseballValidationPolicy = baseballValidationPolicy;
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
        baseballValidationPolicy.isNullOrEmpty(userInput);
        baseballValidationPolicy.hasNoDuplicateNumber(userInput);
        baseballValidationPolicy.isCorrectLength(userInput, 3);
        baseballValidationPolicy.isNumericString(userInput);
        baseballValidationPolicy.hasNoZero(userInput);
    }
}
