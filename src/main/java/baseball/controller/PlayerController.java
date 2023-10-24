package baseball.controller;

import baseball.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private List<Integer> playerNumberList = new ArrayList<>();
    Player player = new Player();

    public List<Integer> putPlayerNumberList(String playerNumber) {

        for (int i = 0; i < playerNumber.length(); i++) {
            playerNumberList.add(i, convertCharacterToInteger(playerNumber, i));
        }

        player.setPlayerNumberList(playerNumberList);

        return player.getPlayerNumberList();
    }

    private int convertCharacterToInteger(String playerNumber, int i) {
        return playerNumber.charAt(i) - '0';
    }

}
