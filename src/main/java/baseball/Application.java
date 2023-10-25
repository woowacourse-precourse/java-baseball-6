package baseball;

import validator.NumberInputValidator;

public class Application {
    public static void main(String[] args) {
        NumberInputValidator numberInputValidator = new NumberInputValidator();
        numberInputValidator.validNumber();
    }
}
