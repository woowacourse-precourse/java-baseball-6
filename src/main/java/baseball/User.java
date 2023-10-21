package baseball;

import baseball.logic.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class User {

    private final InputValidator validator = new InputValidator();

    public String inputNumbers() {
        return Console.readLine();
    }

    public int commandInput() {
        String input = Console.readLine();
        int command = validator.validateCommand(input);

        return command;
    }
}
