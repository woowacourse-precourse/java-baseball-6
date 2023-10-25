package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumber = new ArrayList<>();

    public Player() {
        String[] str = Console.readLine().split("");

        for (int i = 0; i < 3; i++) {
            playerNumber.add(Integer.parseInt(str[i]));
        }

        if (str.length != 3) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다.");
        }
    }

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }
}
