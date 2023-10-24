package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    public List<Integer> inputNumbers;

    public void input() {
        List<Integer> player = new ArrayList<>();
        char[] playerInput = Console.readLine().toCharArray();

        for (char number : playerInput) {
            if (number < '1' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (playerInput.length != 3
                || playerInput[0] == playerInput[1]
                || playerInput[0] == playerInput[2]
                || playerInput[1] == playerInput[2]
        ) {
            throw new IllegalArgumentException();
        }
        for (char number : playerInput) {
            player.add(number - '0');
        }
        inputNumbers = player;
    }
}
