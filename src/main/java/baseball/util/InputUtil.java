package baseball.util;

import baseball.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    private List<Integer> playerNumber;

    public List<Integer> input() {
        playerNumber = new ArrayList<>();
        String inputString = "";
        boolean isValidInput = false;
        while (!isValidInput) {
            inputString = Console.readLine();
            isValidInput = isValidString(inputString);
            makeStringToList(inputString);
        }

        return playerNumber;
    }

    private void makeStringToList(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            playerNumber.add(Integer.parseInt(String.valueOf(inputString.charAt(i))));
        }
    }

    public int inputReplay() {
        String command = "";
        boolean isValidCommand = false;
        while (!isValidCommand) {
            command = Console.readLine();
            isValidCommand = isValidReplayCommand(command);
        }
        return Integer.parseInt(command);
    }

    private boolean isValidString(String input) {
        if (!input.matches("^(?!.*(.).*\\1)[1-9]{3}$")) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getError());
        }
        return input.matches("^(?!.*(.).*\\1)[1-9]{3}$");
    }

    private boolean isValidReplayCommand(String replayCommand) {
        if (!replayCommand.matches("^[12]$")) {
            throw new IllegalArgumentException(ErrorMessage.REPLAY_COMMAND_ERROR.getError());
        }
        return replayCommand.matches("^[12]$");
    }
}
