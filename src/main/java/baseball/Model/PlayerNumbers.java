package baseball.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerNumbers {
    private List<Integer> playerNumbers;

    public void setPlayerNumbers(Set<Integer> playerNumbers) {
        this.playerNumbers = new ArrayList<>(playerNumbers);
    }

    public List<Integer> getPlayerNumber() {
        return this.playerNumbers;
    }


}
