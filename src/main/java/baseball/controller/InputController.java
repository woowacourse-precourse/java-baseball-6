package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    private final InputValidator validator;

    public InputController() {
        validator = new InputValidator();
    }

    public int getBall() {
        return validator.isInteger(Console.readLine());
    }

    public String getCommand() {
        return validator.checkCommand(Console.readLine());
    }
}
