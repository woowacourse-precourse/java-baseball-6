package baseball.variable;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    public List<Integer> playerNumber = new ArrayList<>();

    public void getPlayerNumber() {
        String tempString = Console.readLine();
        String[] str = splitString(tempString);
        for (int i = 0; i < str.size(); i++) {
            playerNumber.add(parseInt(str[i]));
        }
    }

    private String[] splitString(String str) {
        return str.split("");
    }
}
