package baseball;

import java.util.List;

public class GameData {

    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private Integer strikeCnt;
    private Integer ballCnt;
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

    public Integer getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(Integer strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public Integer getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(Integer ballCnt) {
        this.ballCnt = ballCnt;
    }

    public String getGameRepetition() {
        return gameRepetition;
    }

    public void setGameRepetition(String gameRepetition) {
        this.gameRepetition = gameRepetition;
    }


}
