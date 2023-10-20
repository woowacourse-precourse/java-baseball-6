package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballManageController {

    private final GameData gameData;
    private final OutputView view;

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

//    public void setStrikeCnt(Integer strikeCnt) {
//        this.gameData.setStrikeCnt(strikeCnt);
//    }

    public Integer getBallCnt() {
        return this.gameData.getBallCnt();
    }

    /*public void setBallCnt(Integer ballCnt) {
        this.gameData.setBallCnt(ballCnt);
    }*/

    public String getGameRepetition() {
        return this.gameData.getGameRepetition();
    }

    public void setGameRepetition(String gameRepetition) {
        this.gameData.setGameRepetition(gameRepetition);
    }

    public void generateComNums() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        this.gameData.setComputerNumbers(computer);
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

    public void countStrike(List<Integer> computer, List<Integer> player) {
        int strikeCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (player.get(i).equals(computer.get(i))) {
                strikeCnt++;
            }
        }
        this.gameData.setStrikeCnt(strikeCnt);

    }

    public void countBall(List<Integer> computer, List<Integer> player) {
        int ballCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.contains(player.get(i)) && !player.get(i).equals(computer.get(i))) {
                ballCnt++;
            }
        }
        this.gameData.setBallCnt(ballCnt);
    }

    public void printResult(Integer ballCnt, Integer strikeCnt) {
        if (strikeCnt != 0 && ballCnt == 0) {
            view.printStrikeOnlyResult(strikeCnt);
        }
        if (strikeCnt == 0 && ballCnt != 0) {
            view.printBallOnlyResult(ballCnt);
        }
        if (strikeCnt != 0 && ballCnt != 0) {
            view.printBallAndStrikeResult(strikeCnt, ballCnt);
        }
        if (strikeCnt == 0 && ballCnt == 0) {
            view.printNothingResult();
        }
    }

    public void restartInput() {

        String restart = Console.readLine();
        this.gameData.setGameRepetition(restart);
    }

}
