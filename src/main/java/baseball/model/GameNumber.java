package baseball.model;

import java.util.List;

public class GameNumber {
    private String userInputString;
    private List<Integer> userInputNumbers;

    public void setUserInputString(String inputString) {
        this.userInputString = inputString;
    }

    public String getUserInputString() {
        return this.userInputString;
    }

    public void setUserInputNumbers(List<Integer> inputNumbers) {
        this.userInputNumbers = inputNumbers;
    }

    public List<Integer> getUserInputNumbers() {
        return this.userInputNumbers;
    }
}
