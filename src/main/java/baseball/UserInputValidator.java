package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputValidator {
    private final List<Character> userInputCharList = new ArrayList<>();

    public UserInputValidator(String userInput) {
        for (Character c : userInput.toCharArray()) {
            userInputCharList.add(c);
        }
    }

    public void checkValid() {
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValid() {
        return isInputSizeValid() && !isInputDuplicated() && isInputDigitValid();
    }

    private boolean isInputSizeValid() {
        return userInputCharList.size() == SIZE_OF_DIGITS.getValue();
    }

    private boolean isInputDuplicated() {
        Set<Character> userInputCharHashSet = new HashSet<>(userInputCharList);
        return userInputCharHashSet.size() != userInputCharList.size();
    }

    private boolean isInputDigitValid() {
        for (Character c : userInputCharList) {
            if (!(Character.isDigit(c) && isInputInRange(c))) {
                return false;
            }
        }
        return true;
    }

    private boolean isInputInRange(Character c) {
        int number = Character.getNumericValue(c);
        return NUMBER_LOWER_BOUND.getValue() <= number && number <= NUMBER_UPPER_BOUND.getValue();
    }
}
