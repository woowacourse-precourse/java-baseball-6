package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerNumbers = new ArrayList<Integer>();

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return this.playerNumbers;
    }

}
