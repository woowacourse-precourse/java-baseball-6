package baseball.io.input;

import baseball.io.input.validation.Validation;

public interface Input {

    String nextLine();

    default String nextLineWithValidation(Validation<String> validator) {
        String line = nextLine();
        if (!validator.validation(line)) {
            throw new IllegalArgumentException();
        }
        return line;
    }
}
