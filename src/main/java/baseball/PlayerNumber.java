package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    public List<Integer> inputNumbers;

    public void input() {
        List<Integer> player = new ArrayList<>();
        String playerInput = Console.readLine();
        for (char number : playerInput.toCharArray()) {
            player.add(number - '0');
        }
        inputNumbers = player;
    }
}
