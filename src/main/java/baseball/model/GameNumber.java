package baseball.model;

import baseball.controller.NumberValidator;

public class GameNumber {
    private String inputNumber;
    NumberValidator numberValidator = new NumberValidator();

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
        numberValidator.toValidateNumber(inputNumber);
    }

    public String getInputNumber() {
        return inputNumber;
    }
}
