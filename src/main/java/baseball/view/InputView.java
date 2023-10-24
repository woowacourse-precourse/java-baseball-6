package baseball.view;

import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readUserInput() {
        String input = Console.readLine();
        if(InputValidator.isValidUserInput(input)) {
            return input;
        }

        throw new IllegalArgumentException();
    }

    public String readUserRetryInput() {
        String input = Console.readLine();
        if(InputValidator.isValidUserRetryGameInput(input)) {
            return input;
        }

        throw new IllegalArgumentException();
    }
}
