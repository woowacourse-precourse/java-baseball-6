package baseball.input;

import java.util.Scanner;

import baseball.validation.Validation;

public class Input {

    private final String messagePrefix;
    private final Validation<String> inputValidator;
    private final Scanner scanner;

    public Input(Validation<String> inputValidator) {
        this("", inputValidator);
    }

    public Input(String messagePrefix, Validation<String> inputValidator) {
        this.inputValidator = inputValidator;
        this.messagePrefix = messagePrefix;
        this.scanner = new Scanner(System.in);
    }

    public String nextLine() throws IllegalArgumentException {
        System.out.print(messagePrefix);
        String inputValue = scanner.nextLine();
        boolean isValid = inputValidator.validation(inputValue);
        if (!isValid) {
            throw new IllegalArgumentException();
        }
        return inputValue;
    }
}
