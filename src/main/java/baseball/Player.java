package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private List<Integer> playerNumbers;

    public List<Integer> init(){
        playerNumbers = new ArrayList<>();
        String playerInput = Console.readLine();
        if(playerInput.matches(".*([0-9]).*\\1.*")||playerInput.length()>3 || playerInput.equals("")) {
            throw new IllegalArgumentException();
        }
        String[] playerInputToArr = playerInput.split("");
        for(int i=0; i<playerInputToArr.length; i++){
            int number = Integer.parseInt(playerInputToArr[i]);
            playerNumbers.add(number);
        }
        return playerNumbers;
    }

    public int finishGame() {
        String playerInput = Console.readLine();
        if (playerInput.matches(".*([0-9]).*\\1.*") || playerInput.length() > 1 || playerInput.equals("")) {
            throw new IllegalArgumentException();
        }
        int playerInputToInt = Integer.parseInt(playerInput);
        return playerInputToInt;
    }
}
