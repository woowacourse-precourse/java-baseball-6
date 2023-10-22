package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.PlayerNumber;

public class InputView {

    private InputView() {
    }

    public static PlayerNumber inputPlayerNumber() {
        String number = readLine();
        PlayerNumber playerNumber = new PlayerNumber(number);
        return playerNumber;
    }

    public static String inputRetryCommand() {
        String command = readLine();
        return command;
    }
}
