package baseball;

import baseball.config.GameConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    private List<Character> userInputList;

    public List<Character> checkUserInput(String userInput) {

        ConvertUserInputToList(userInput);
        isAllCheck();
        return userInputList;
    }

    public void checkRetryInput(String retryInput){

        if (retryInput.equals("1") || retryInput.equals("2")) {
            return;
        }

        throw new IllegalArgumentException();
    }


    private void ConvertUserInputToList(String userInput) {
        this.userInputList = new ArrayList<>();

        for (int i = 0; i < userInput.length(); i++) {
            this.userInputList.add(userInput.charAt(i));
        }
    }

    private void isAllCheck() {
        if (isCheckLength() && isAllCorrectNumber() && isNotDuplicateNumber()) {
            return;
        }

        throw new IllegalArgumentException();
    }

    private boolean isCheckLength() {
        if (userInputList.size() == GameConfig.CORRECT_LENGTH) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private boolean isAllCorrectNumber() {
        userInputList.forEach(num -> {
            if (!(GameConfig.START_NUMBER <= num && num <= GameConfig.END_NUMBER)) {
                throw new IllegalArgumentException();
            }
        });

        return true;
    }

    private boolean isNotDuplicateNumber() {
        Set<Character> userInputSet = new HashSet<>(userInputList);

        if (userInputSet.size() == GameConfig.CORRECT_LENGTH) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
