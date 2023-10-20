package baseball.Model;

import java.util.ArrayList;

public class GameData {
    private ArrayList<Integer> computerNumber;
    private ArrayList<Integer> playerInput;
    private int ballCount;
    private int strikeCount;
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

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }


}
