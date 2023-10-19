package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private List<Integer> userInputList;

    public List<Integer> checkUserInput(String userInput) {

        ConvertUserInputToList(userInput);
        isAllCheck();
        return userInputList;
    }

    private void ConvertUserInputToList(String userInput) {
        this.userInputList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            Character num = userInput.charAt(i);
            this.userInputList.add(Character.getNumericValue(num));
        }
    }

    private void isAllCheck() {
        if (isCheckLength() && isAllCorrectNumber() && isNotDuplicateNumber()) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private boolean isCheckLength() {
        if (userInputList.size() == 3) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private boolean isAllCorrectNumber() {
        userInputList.forEach(num -> {
            if (!(1 <= num && num <= 9)) {
                throw new IllegalArgumentException();
            }
        });

        return true;
    }

    private boolean isNotDuplicateNumber() {
        Set<Integer> userInputSet = new HashSet<>(userInputList);

        if (userInputSet.size() == 3) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
