package baseball;

import java.util.List;

public class Data {
    private String userInput;
    private List<String> userInputList;
    private int randomNumber;
    private List<String> randomNumberList;

    public String getUserInput() {
        return userInput;
    }

    public List<String> getUserInputList() {
        return userInputList;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public List<String> getRandomNumberList() {
        return randomNumberList;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setUserInputList(List<String> userInputList) {
        this.userInputList = userInputList;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public void setRandomNumberList(List<String> randomNumberList) {
        this.randomNumberList = randomNumberList;
    }
}
