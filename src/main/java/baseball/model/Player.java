package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Integer> playerNumberList;

    public List<Integer> getPlayerNumberList(String playerNumber) {
        playerNumberList = new ArrayList<>();

        for (int i = 0; i < playerNumber.length(); i++) {
            playerNumberList.add(i, convertCharacterToInteger(playerNumber, i));
        }

        return playerNumberList;
    }

    private int convertCharacterToInteger(String playerNumber, int i) {
        return playerNumber.charAt(i) - '0';
    }


}
