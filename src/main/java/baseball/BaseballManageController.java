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

    public List<Integer> getPlayerNumbers() {
        return this.gameData.getPlayerNumbers();
    }

    public void setPlayerNumbers(List<Integer> playerNumbers) {
        this.gameData.setPlayerNumbers(playerNumbers);
    }

    public Integer getStrikeCnt() {
        return this.gameData.getStrikeCnt();
    }

    public Integer getBallCnt() {
        return this.gameData.getBallCnt();
    }


    public String getGameRepetition() {
        return this.gameData.getGameRepetition();
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
        this.playerNumsInputCheck(playerStringNumsInput);
        this.playerInputTypeCheck(playerStringNumsInput);
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
        this.RestartInputCheck(restart);
        this.gameData.setGameRepetition(restart);
    }

    public void printStart() {
        view.printStart();
    }

    public void printRequirePlayerInput() {
        view.printRequirePlayerInput();
    }

    public void printEndgame() {
        view.printEndgame();
    }

    public void printAskRestart() {
        view.printAskRestart();
    }

    public void playerNumsInputCheck(String playerInput) throws IllegalArgumentException{

        //입력 자리수 확인
        if(playerInput.length() != 3) {
            throw new IllegalArgumentException();
        }
        //입력 숫자 중복 여부 확인
        for(int i = 0; i < 3; i++) {
            for(int j = i + 1; j < 3; j++) {
                if(playerInput.charAt(i) == playerInput.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        //0 포함 여부 확인
        if(playerInput.contains("0")) {
            throw new IllegalArgumentException();
        }
    }

    public void playerInputTypeCheck(String playerInput) throws IllegalArgumentException{

        try {
            Double.parseDouble(playerInput);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void RestartInputCheck(String restartInput) throws IllegalArgumentException{

        List<String> restartInputList = List.of("1", "2");
        if(!restartInputList.contains(restartInput)) {
            throw new IllegalArgumentException();
        }
    }
}
