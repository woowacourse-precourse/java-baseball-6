package baseball.model;

import baseball.controller.NumberValidator;

public class GameNumber {
    private String inputNumber;
    private int[] playerNumbers;
    NumberValidator numberValidator = new NumberValidator();

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
}
