package baseball;

import java.util.List;

public class GameData {

    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private Integer strikeCnt;
    private Integer ballCnt;
    private Integer gameRepetition;

    public GameData(List<Integer> computerNumbers, List<Integer> playerNumbers, Integer strikeCnt, Integer ballCnt, Integer gameRepetition) {
        this.computerNumbers = computerNumbers;
        this.playerNumbers = playerNumbers;
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
        this.gameRepetition = gameRepetition;
    }

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

    public Integer getGameRepetition() {
        return gameRepetition;
    }

    public void setGameRepetition(Integer gameRepetition) {
        this.gameRepetition = gameRepetition;
    }
}
