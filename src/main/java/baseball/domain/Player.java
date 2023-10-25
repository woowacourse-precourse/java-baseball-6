package baseball.domain;

import java.util.List;

public class Player {
    List<Integer> playerNumbers;

    public Player(List<Integer> userInput) {
        playerNumbers = userInput;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
