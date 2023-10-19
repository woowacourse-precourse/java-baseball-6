package baseball.io.input;

import baseball.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    private final String messagePrefix;
    private final Validation<String> inputValidator;

    public Input(Validation<String> inputValidator) {
        this("", inputValidator);
    }

    public Input(String messagePrefix, Validation<String> inputValidator) {
        this.inputValidator = inputValidator;
        this.messagePrefix = messagePrefix;
    }

    public String nextLine() throws IllegalArgumentException {
        System.out.print(messagePrefix);
        String inputValue = Console.readLine();
        boolean isValid = inputValidator.validation(inputValue);
        if (!isValid) {
            throw new IllegalArgumentException();
        }
        return inputValue;
    }

    public String nextLineWithNoEffect() {
        return Console.readLine();
    }
}
