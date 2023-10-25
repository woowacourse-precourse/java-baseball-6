package baseball.domain;

import camp.nextstep.edu.missionutils.Console;
import baseball.logic.InputValidator;

public class User {

    private final InputValidator validator = new InputValidator();

    public String inputNumbers() {
        return Console.readLine();
    }

    public int commandInput() {
        String input = Console.readLine();

        return validator.validateCommand(input);
    }
}
