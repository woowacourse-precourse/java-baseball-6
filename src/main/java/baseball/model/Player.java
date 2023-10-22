package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerGameNumber = new ArrayList<>();

    public List<Integer> getPlayerGameNumber() {
        return playerGameNumber;
    }

    public void setPlayerGameNumber(List<Integer> input) {
        this.playerGameNumber = input;
    }
}