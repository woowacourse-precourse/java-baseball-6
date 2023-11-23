package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String askRestart() {
        String status = readLine();
        return status;
    }

    public static String getPlayerInput() {
        String playerInput = Console.readLine();
        return playerInput;
    }
}
