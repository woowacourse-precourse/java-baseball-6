package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballManageController {

    private GameData gameData;
    private OutputView view;

    public BaseballManageController(GameData gameData, OutputView view) {
        this.gameData = gameData;
        this.view = view;
    }

    public List<Integer> getComputerNumbers() {
        return this.gameData.getComputerNumbers();
    }

    public void setComputerNumbers(List<Integer> computerNumbers) {
        this.gameData.setComputerNumbers(computerNumbers);
    }

    public List<Integer> getPlayerNumbers() {
        return this.gameData.getPlayerNumbers();
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.gameData.setPlayerNumbers(playerNumbers);
    }

    public Integer getStrikeCnt() {
        return this.gameData.getStrikeCnt();
    }

    public void setStrikeCnt(Integer strikeCnt) {
        this.gameData.setStrikeCnt(strikeCnt);
    }

    public Integer getBallCnt() {
        return this.gameData.getBallCnt();
    }

    public void setBallCnt(Integer ballCnt) {
        this.gameData.setBallCnt(ballCnt);
    }

    public Integer getGameRepetition() {
        return this.gameData.getGameRepetition();
    }

    public void setGameRepetition(Integer gameRepetition) {
        this.gameData.setGameRepetition(gameRepetition);
    }

    public List<Integer> playerNumsInput() {
        String playerStringNumsInput = Console.readLine();
        List<Integer> playerNumsTemp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int numericValue = Character.getNumericValue(playerStringNumsInput.charAt(i));
            playerNumsTemp.add(numericValue);
        }
        return playerNumsTemp;
    }

    public Integer countStrike(List<Integer> computer, List<Integer> player) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strikeCnt++;
            }
        }
        return strikeCnt;
    }

    public Integer countBall(List<Integer> computer, List<Integer> player) {
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(player.get(i)) && !player.get(i).equals(computer.get(i))) {
                ballCnt++;
            }
        }
        return ballCnt;
    }
}
