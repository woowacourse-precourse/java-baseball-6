package baseball.model;

import baseball.util.NumberValidator;

public class PlayerNumber {
    private String inputNumber;
    NumberValidator numberValidator = new NumberValidator();

    public void setInputNumber(String inputNumber) {
        numberValidator.validateDigit(inputNumber);
        numberValidator.validateRange(inputNumber);
        numberValidator.validateDuplicateNumber(inputNumber);

        this.inputNumber = inputNumber;
    }

    public String getInputNumber() {
        return inputNumber;
    }
}
