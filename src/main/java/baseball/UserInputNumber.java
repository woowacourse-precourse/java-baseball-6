package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumber {
    private final UserInputValidation userInputValidation;

    public UserInputNumber() {
        userInputValidation = new UserInputValidation();
    }

    public List<Integer> parseToIntList(String userInput) {
        List<Integer> integerList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            integerList.add(Character.getNumericValue(c));
        }
        return integerList;
    }
}
