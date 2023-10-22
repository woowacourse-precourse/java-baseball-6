package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserInputNumber {
    private final UserInputValidation userInputValidation;

    public UserInputNumber() {
        userInputValidation = new UserInputValidation();
    }

    public BaseBallNumber parseBaseBallNumber(String userInput) {
        if (!userInputValidation.isValidGameNumber(userInput)) {
            return null;
        }
        List<Integer> integerList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            integerList.add(Character.getNumericValue(c));
        }
        return new BaseBallNumber(integerList);
    }

    public boolean isValidRestartNumber(String inputNumber) {
        return userInputValidation.isValidRestartNumber(inputNumber);
    }
}
