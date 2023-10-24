package baseball.service;

import baseball.view.printGameMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class playerService {
    private static int NUMBER_MAXSIZE = 3;
    private printGameMessage gameMessage = new printGameMessage();

    public List<Integer> selectPlayerNumber() {
        gameMessage.inputNumberMessage();
        String playerNumber = Console.readLine();

        if (playerNumber.length() > NUMBER_MAXSIZE) {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }

        return stringToIntArray(playerNumber);
    }

    public List<Integer> stringToIntArray(String playerNumber) {
        List<Integer> digits = new ArrayList<>();

        for (int i = 0; i < playerNumber.length(); i++) {
            digits.add(playerNumber.charAt(i) - '0');
        }

        return digits;
    }
}
