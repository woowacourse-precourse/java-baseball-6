package baseball.handler;

import baseball.constants.GameConstants;
import camp.nextstep.edu.missionutils.Console;
import baseball.validator.InputValidator;

public class InputHandler {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputValidator inputValidator = new InputValidator();

    public String askUserBaseballNumber() {
        outputHandler.printInputRequestMessage();
        String input = Console.readLine();
        inputValidator.checkBaseballNumber(input);

        return input;
    }

    public boolean askRestart() {
        outputHandler.printAskGameRestartMessage();
        String input = Console.readLine();
        inputValidator.checkRestartInput(input);

        return input.equals(GameConstants.RESTART_FLAG);
    }
}
