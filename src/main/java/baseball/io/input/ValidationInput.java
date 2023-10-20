package baseball.io.input;

import baseball.validation.Validation;

public class ValidationInput implements Input {

    private final Input originalInput;
    private final Validation<String> inputValidator;

    public ValidationInput(Input input, Validation<String> validator) {
        this.originalInput = input;
        this.inputValidator = validator;
    }

    @Override
    public String nextLine() {
        String readString = originalInput.nextLine();
        if (!inputValidator.validation(readString)) {
            throw new IllegalArgumentException();
        }
        return readString;
    }
}
