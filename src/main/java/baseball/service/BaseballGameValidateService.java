package baseball.service;

import baseball.validator.InputValidator;

public class BaseballGameValidateService {

    private final InputValidator inputValidator = new InputValidator();

    public void validateInputNumber(String inputNumber) {
        inputValidator.validateInputNumber(inputNumber);
    }

    public void validateGameRetryOrEndCommand(String gameRetryOrCommand) {
        inputValidator.validateInputRestartOrEndNumber(gameRetryOrCommand);
    }
}
