package baseball.computer;

import java.util.HashMap;

public class ComputerNumberHashMap {

    private HashMap<Integer, Integer> computerNumberHashMap;

    public ComputerNumberHashMap(HashMap<Integer, Integer> computerNumberHashMap) {
        this.computerNumberHashMap = computerNumberHashMap;
    }

    public boolean contain(int playerNumber) {
        return computerNumberHashMap.containsKey(playerNumber);
    }

    public boolean equalIndex(int playerNumber, int index) {
        return computerNumberHashMap.get(playerNumber) == index;
    }

}
