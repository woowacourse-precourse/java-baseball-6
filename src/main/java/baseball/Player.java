package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Integer> playerNumberStore = new ArrayList<>();

    public void settingPlayerNumber(int[] inputPlayerNumbers) {
        for (int inputPlayerNumber : inputPlayerNumbers) {
            playerNumberStore.add(inputPlayerNumber);
        }
    }

    public int getPlayerNumberAt(int index) {
        return playerNumberStore.get(index);
    }

    public void resetPlayerNumberStore() {
        playerNumberStore.clear();
    }
}