package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {

    public List<Integer> playerNumberToList(String playerNumber) {
        List<Integer> playerNumberList = new ArrayList<>();
        for(int i=0; i<playerNumber.length(); i++) {
            playerNumberList.add(Integer.parseInt(String.valueOf(playerNumber.charAt(i))));
        }
        return playerNumberList;
    }
}
