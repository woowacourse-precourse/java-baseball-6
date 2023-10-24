package baseball.model;

import java.util.List;

public class GameNumber {
    private String userInputString;
    private List<Integer> userInputNumbers;
    private List<Integer> computerGenerateNumbers;

    public void saveUserInputNumbers(String userInputString, List<Integer> userInputNumbers) {
        this.userInputString = userInputString;
        this.userInputNumbers = userInputNumbers;
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
