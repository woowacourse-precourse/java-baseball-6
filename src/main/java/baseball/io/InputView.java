package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readAttemptNumbers() {
        final String input = Console.readLine();
        inputValidator.validateNumber(input);
        return input;
    }
}
