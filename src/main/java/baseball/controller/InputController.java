package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputController {
    private final InputValidator validator;

    public InputController() {
        validator = new InputValidator();
    }

    public List<Integer> getBall() {
        return validator.checkBall(Console.readLine());
    }

    public String getCommand() {
        return validator.checkCommand(Console.readLine());
    }
}
