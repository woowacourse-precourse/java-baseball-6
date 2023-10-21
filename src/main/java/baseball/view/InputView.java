package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputValidation inputValidation;

    public InputView() {
        inputValidation = new InputValidation();
    }

    public String readLine() {
        String input = Console.readLine();
        inputValidation.validate(input);
        return input;
    }
}
