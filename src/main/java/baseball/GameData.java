package baseball;

import java.util.List;

public class GameData {

    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private int strikeCount;
    private int ballCount;
    private String gameRepetition = "1";

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public String getGameRepetition() {
        return gameRepetition;
    }

    public void setGameRepetition(String gameRepetition) {
        this.gameRepetition = gameRepetition;
    }
}