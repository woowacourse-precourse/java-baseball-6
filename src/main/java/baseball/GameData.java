package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameData {

    private List<Integer> computerNumbers;
    private List<Integer> playerNumbers;
    private Integer strikeCnt;
    private Integer ballCnt;
    private Integer gameRepetition = 1;

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

    public List<Integer> generateComNums(List<Integer> computer) {
        computer = this.getComputerNumbers();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
