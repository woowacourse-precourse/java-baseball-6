package baseball;

import static baseball.Constants.SIZE_OF_DIGITS;

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
        return isInputSizeValid() && !isInputDuplicated();
    }

    private boolean isInputSizeValid() {
        return userInputCharList.size() == SIZE_OF_DIGITS.getValue();
    }

    private boolean isInputDuplicated() {
        Set<Character> userInputCharHashSet = new HashSet<>(userInputCharList);
        return userInputCharHashSet.size() != userInputCharList.size();
    }
}
