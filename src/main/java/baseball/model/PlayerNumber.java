package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private final List<Integer> playerNumber;

    public PlayerNumber(String numbers) {
        this.playerNumber = generatePlayerNumber(numbers);
    }

    public List<Integer> generatePlayerNumber(String numbers) {
        List<Integer> playerNumber = new ArrayList<>();
        for (char number : numbers.toCharArray()) {
            playerNumber.add(Character.getNumericValue(number));
        }
        return playerNumber;
    }

}
