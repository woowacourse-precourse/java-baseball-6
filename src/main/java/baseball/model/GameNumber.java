package baseball.model;

import baseball.controller.NumberValidator;
import baseball.controller.RandomUtility;

public class GameNumber {
    private String inputNumber;
    private int[] playerNumbers;
    private int[] randomNumbers;
    NumberValidator numberValidator = new NumberValidator();
    RandomUtility randomUtility = new RandomUtility();

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber.replaceAll(" ", "");
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setPlayerNumbers(int[] playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }

    public void setRandomNumbers(int[] randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public int[] getRandomNumbers() {
        return randomNumbers;
    }
}
