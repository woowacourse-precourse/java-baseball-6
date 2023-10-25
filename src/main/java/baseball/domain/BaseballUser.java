package baseball.domain;

import baseball.policy.ValidationPolicy;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballUser implements User {

    private ValidationPolicy validationPolicy;
    private List<Integer> numbers;

    public BaseballUser(ValidationPolicy validationPolicy) {
        this.validationPolicy = validationPolicy;
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
        validationPolicy.isNullOrEmpty(userInput);
        validationPolicy.hasNoDuplicateNumber(userInput) ;
        validationPolicy.isCorrectLength(userInput, 3);
        validationPolicy.isNumericString(userInput);
        validationPolicy.hasNoZero(userInput);
    }
}
