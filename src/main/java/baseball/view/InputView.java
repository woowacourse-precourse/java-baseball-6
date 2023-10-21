package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readNumbers() {
        String input = readLine();
        inputValidator.validateIsNumeric(input);
        return input;
    }

    public String readEndNumber() {
        String input = readLine();
        return input;
    }
}
