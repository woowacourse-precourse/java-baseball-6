package baseball.handler;

import camp.nextstep.edu.missionutils.Console;
import baseball.handler.OutputHandler;

public class InputHandler {

    private final OutputHandler outputHandler = new OutputHandler();

    public String askUserInputNumber() {
        outputHandler.printInputRequestMessage();
        return Console.readLine();
    }

    public boolean askRestart() {
        outputHandler.printAskGameRestartMessage();
        String input = Console.readLine();

        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException();
        }

        return "1".equals(input);
    }
}
