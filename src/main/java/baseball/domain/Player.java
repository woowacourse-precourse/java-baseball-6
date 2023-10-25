package baseball.domain;

import java.util.List;

public class Player {
    private List<Integer> playerNumbers;

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
