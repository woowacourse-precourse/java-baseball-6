package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private static List<Integer> playerNumber;

    public List<Integer> getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String numbers) {
        if (NumbersValidator.validate(numbers)) {
            convert(numbers);
        }
    }

    private static void convert(String numbers) {
        playerNumber = new ArrayList<>();

        for (String s : numbers.split("")) {
            playerNumber.add(Integer.parseInt(s));
        }
    }
}
