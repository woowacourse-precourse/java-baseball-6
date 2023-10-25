package baseball.model;

import java.util.List;

public class Game {
    private String userInput;
    private List<Integer> userNumbers;
    private List<Integer> randomNumbers;

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }
}
