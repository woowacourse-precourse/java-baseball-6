package baseball.variable;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class PlayerNumber {
    public List<Integer> playerNumber = new ArrayList<>();

    public void getPlayerNumber() {
        String tempString = Console.readLine();
        String[] str = splitString(tempString);
        for (int i = 0; i < str.length; i++) {
            int n = Integer.parseInt(str[i]);
            playerNumber.add(n);
        }
    }

    private String[] splitString(String str) {
        return str.split("");
    }
}
