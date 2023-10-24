package baseball.model;

import java.util.List;

public class Number {
    private List<Integer> playerNumbers;
    private List<Integer> computerNumbers;

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return this.playerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
