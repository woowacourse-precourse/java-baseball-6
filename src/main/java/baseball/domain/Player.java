package baseball.domain;

import java.util.List;
import java.util.ArrayList;

public class Player {
    public List<Integer> getPlayerNumbers(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        String[] inputArr = input.split("");
        for (String tmp : inputArr) {
            playerNumbers.add(Integer.parseInt(tmp));
        }
        return playerNumbers;
    }

    public int getFinishInput(String input) {
        return Integer.parseInt(input);
    }
}