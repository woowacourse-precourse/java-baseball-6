package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public int inputNumber() {
        String numberInput = "";
        while (isValidInput(numberInput)) {
            numberInput = Console.readLine();
        }
        return Integer.parseInt(numberInput);
    }

    public int inputReplay() {
        String command = "";
        while (isValidReplayCommand(command)) {
            command = Console.readLine();
        }
        return Integer.parseInt(command);
    }

    private boolean isValidInput(String input) {
        return input.matches("^(?!.*(.).*\\1)[1-9]{3}$");
    }

    private boolean isValidReplayCommand(String replayCommand) {
        return replayCommand.matches("[12]");
    }
}
