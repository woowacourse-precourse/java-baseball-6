package baseball.controller;

import baseball.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerController {

    private List<Integer> playerNumberList = new ArrayList<>();
    Player player = new Player();

    public List<Integer> putPlayerNumberList(String playerNumber) {

        for (int i = 0; i < playerNumber.length(); i++) {
            playerNumberList.add(i, convertCharterToInteger(playerNumber, i));
        }

        player.setPlayerNumberList(playerNumberList);

        return player.getPlayerNumberList();
    }

    private int convertCharterToInteger(String playerNumber, int i) {
        return playerNumber.charAt(i) - '0';
    }

}
