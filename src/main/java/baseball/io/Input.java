package baseball.io;

import baseball.validator.UserInputValidator;
import camp.nextstep.edu.missionutils.Console;

public class Input {

    public String userNumberInput() {
        String userNumberInput = Console.readLine();
        UserInputValidator.validateIsNumberAndRange(userNumberInput);
        UserInputValidator.validateLength(userNumberInput);

        return userNumberInput;
    }

    public String finishOrRestartInput() {
        String userInput = Console.readLine();
        UserInputValidator.validateFinishOrRestart(userInput);

        return userInput;
    }
}
