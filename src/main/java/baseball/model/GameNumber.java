package baseball.model;

import java.util.List;

public class GameNumber {
    private String userInputString;
    private List<Integer> userInputNumbers;
    private List<Integer> computerGenerateNumbers;

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

    public void setComputerGenerateNumbers(List<Integer> computerGenerateNumbers) {
        this.computerGenerateNumbers = computerGenerateNumbers;
    }

    public List<Integer> getComputerGenerateNumbers() {
        return this.computerGenerateNumbers;
    }
}
