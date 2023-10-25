package baseball.domain;


import baseball.exception.UserInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputNumber {
    private List<Integer> userNumber = new ArrayList<>();

    public UserInputNumber(String userInput) {
        this.userNumber = createUserNumber(userInput);
    }

    private List<Integer> createUserNumber(String userInput) {
        List<Integer> userNumber = stringToInt(userInput);
        UserInputException.isDigit(userNumber);
        UserInputException.isDuplicate(userNumber);
        UserInputException.isRange(userNumber);

        return userNumber;
    }

    private List<Integer> stringToInt(String userInput) {
        this.userNumber = userInput.chars().mapToObj(Character::getNumericValue).collect(Collectors.toList());
        return userNumber;
   }
    public List<Integer> getUserNumber() {
        return userNumber;
    }
}
