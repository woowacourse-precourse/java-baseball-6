package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.domain.PlayerNumber;

public class InputView {

    public PlayerNumber inputPlayerNumber() {
        String number = readLine();
        PlayerNumber playerNumber = new PlayerNumber(number);
        return playerNumber;
    }
}
