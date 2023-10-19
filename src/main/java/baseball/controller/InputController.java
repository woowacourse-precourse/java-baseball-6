package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

public class InputController {
    public int getBall() {
        InputValidator validator = new InputValidator();
        return validator.isInteger(Console.readLine());
    }

    public String getCommand() {
        InputValidator validator = new InputValidator();
        return validator.checkCommand(Console.readLine());
    } 
}
