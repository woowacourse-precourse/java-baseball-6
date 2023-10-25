package baseball.util;

import baseball.constant.ErrorMessage;
import baseball.constant.GameConstant;
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
        String numberRegex = "^(?!.*(.).*\\1)[" +
                GameConstant.NUMBER_START_INCLUSIVE.getConstant() + "-" +
                GameConstant.NUMBER_END_INCLUSIVE.getConstant() + "]{" +
                GameConstant.NUMBER_COUNT.getConstant() + "}$";
        if (!input.matches(numberRegex)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT_ERROR.getError());
        }
        return input.matches(numberRegex);
    }

    private boolean isValidReplayCommand(String replayCommand) {
        String replayRegex = "^[" + GameConstant.REPLAY.getConstant() + GameConstant.QUIT.getConstant() + "]$";
        if (!replayCommand.matches(replayRegex)) {
            throw new IllegalArgumentException(ErrorMessage.REPLAY_COMMAND_ERROR.getError());
        }
        return replayCommand.matches(replayRegex);
    }
}
