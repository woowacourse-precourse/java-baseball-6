package baseball.model;

import java.util.Arrays;

import baseball.controller.NumberValidator;
import baseball.controller.RandomUtility;

public class GameNumber {
    private String inputNumber;
    private int[] playerNumbers;
    private int[] randomNumbers;
    NumberValidator numberValidator = new NumberValidator();
    RandomUtility randomUtility = new RandomUtility();

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
        setPlayerNumbers();
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public void setPlayerNumbers() {
        playerNumbers = numberValidator.toValidateNumber(inputNumber);
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }

    public void setRandomNumbers() {
        randomNumbers = randomUtility.generateRandomNumbers();
        System.out.println("randomNumbers: " + Arrays.toString(randomNumbers));
    }

    public int[] getRandomrNumbers() {
        return randomNumbers;
    }
}
