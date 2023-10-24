package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputNumber {
    private static final int NUMBER_CNT = 3;
    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;

    private final List<Integer> userInput;

    public UserInputNumber(List<Integer> userInput) {
        // 유효성 검증
        validateLength(userInput);
        validateRange(userInput);
        validateDuplicate(userInput);
        this.userInput = userInput;
    }

    private void validateDuplicate(List<Integer> userInput) {
        Set<Integer> checkDuplicate = new HashSet<>();
        for (Integer user : userInput) {
            if (checkDuplicate.contains(user)) {
                throw new IllegalArgumentException();
            }
            checkDuplicate.add(user);
        }
    }

    private void validateRange(List<Integer> userInput) {
        for (Integer i : userInput) {
            if (i > NUMBER_MAX || i < NUMBER_MIN) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateLength(List<Integer> userInput) {
        if (userInput.size() != NUMBER_CNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getUserInput() {
        return userInput;
    }

}
