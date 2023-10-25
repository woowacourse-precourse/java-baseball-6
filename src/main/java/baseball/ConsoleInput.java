package baseball;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInput implements Input {
    private InputValidation inputValidation;

    public ConsoleInput() {
        this.inputValidation = new InputValidation();
    }

    private String getInput() {
        return Console.readLine().strip();
    }

    @Override
    public String getRestartInput() throws IllegalArgumentException {
        String input = getInput();
        inputValidation.validateRestartInput(input);

        return input;
    }

    @Override
    public String getGameInput() throws IllegalArgumentException {
        String input = getInput();
        inputValidation.validateGameInput(input);

        return input;
    }
}
