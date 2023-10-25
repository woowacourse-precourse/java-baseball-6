package baseball.ui.input.component;

import baseball.ui.input.validator.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputComponentForAnswer implements InputComponent {

    private final InputValidator inputValidator;

    public InputComponentForAnswer(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public String getValidUserInput() {
        return inputValidator.validateInput(Console.readLine());
    }

}
