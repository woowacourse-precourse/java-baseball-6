package baseball.domain;

import java.util.List;

public class GameNumber {
    private String userInputString;
    private List<Integer> userNumbers;
    private List<Integer> computerNumbers;


    public String getUserInputString() {
        return userInputString;
    }

    public void setUserInputString(String userInputString) {
        this.userInputString = userInputString;
    }
    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }
}
