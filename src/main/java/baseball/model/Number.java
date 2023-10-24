package baseball.model;

import java.util.List;

public class Number {
    private String playerNumber;
    private List<Integer> playerNumbers;
    private List<Integer> ComputerNumbers;

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return ComputerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        ComputerNumbers = computerNumbers;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber.replaceAll(" ", "");
    }
}
