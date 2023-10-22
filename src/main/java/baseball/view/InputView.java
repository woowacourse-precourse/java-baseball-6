package baseball.view;

import baseball.domain.PlayerNumber;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {
    }

    public static PlayerNumber inputPlayerNumber() {
        String number = Console.readLine();
        PlayerNumber playerNumber = new PlayerNumber(number);
        return playerNumber;
    }

    public static String inputRetryCommand() {
        String command = Console.readLine();
        return command;
    }
}
