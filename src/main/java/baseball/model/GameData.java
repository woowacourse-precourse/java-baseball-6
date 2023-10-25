package baseball.model;

import java.util.ArrayList;

public class GameData {

    private ArrayList<Integer> computerNumber;
    private ArrayList<Integer> playerInput;

    public ArrayList<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(ArrayList<Integer> computerNumber) {
        this.computerNumber = computerNumber;
    }

    public ArrayList<Integer> getPlayerInput() {
        return playerInput;
    }

    public void setPlayerInput(ArrayList<Integer> playerInput) {
        this.playerInput = playerInput;
    }

}
