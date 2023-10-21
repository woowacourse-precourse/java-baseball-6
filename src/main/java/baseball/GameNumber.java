package baseball;

import java.util.ArrayList;
import java.util.List;

public class GameNumber {
    private List<Integer> gameNumber;

    public GameNumber() {
        this.gameNumber = new ArrayList<>();
    }

    public List<Integer> getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(List<Integer> gameNumber) {
        this.gameNumber = gameNumber;
    }
}
