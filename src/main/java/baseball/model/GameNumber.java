package baseball.model;

import java.util.List;

public class GameNumber {
    private String inputNumber;
    private List<Integer> playerNumbers;
    private List<Integer> randomNumbers;

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber.replaceAll(" ", "");
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setRandomNumbers(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
