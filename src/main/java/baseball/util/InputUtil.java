package baseball.util;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {

    private List<Integer> playerNumber;

    public List<Integer> input() {
        playerNumber = new ArrayList<>();
        boolean isValidInput = false;
        while (!isValidInput) {
            String inputString = Console.readLine();
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
        while (!isValidReplayCommand(command)) {
            command = Console.readLine();
            System.out.println("InputUtil.inputReplay : " + command);
        }
        return Integer.parseInt(command);
    }

    //서로다른 3가지 숫자인지 체크
    private boolean isValidString(String input) {
        return input.matches("^(?!.*(.).*\\1)[1-9]{3}$");
    }

    private boolean isValidReplayCommand(String replayCommand) {
        return replayCommand.matches("^[12]$");
    }
}
