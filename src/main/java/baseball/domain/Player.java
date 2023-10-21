package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Integer> playerNumbers = new ArrayList<>();

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }
}

