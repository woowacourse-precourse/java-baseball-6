package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidator inputValidator;

    public InputView() {
        inputValidator = new InputValidator();
    }

    public String readInput() {
        String input = Console.readLine();
        inputValidator.validateInput(input);
        return input;
    }
}
