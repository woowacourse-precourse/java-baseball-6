package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserInputNumbers {

    private final List<Number> userNumberList;

    public UserInputNumbers(String userInput) {
        this.userNumberList = userInputToNumbers(userInput);
    }

    private List<Number> userInputToNumbers(String userInput) {
        return userInput
                .chars()
                .mapToObj(each -> new Number(Character.getNumericValue(each)))
                .collect(Collectors.toList());
    }

    public List<Number> getUserNumberList() {
        return userNumberList;
    }
}
