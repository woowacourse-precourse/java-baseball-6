package baseball;

import java.util.List;

public class Game {
    public boolean start(){ //게임 시작
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        UserInputHandler userInputHandler = new UserInputHandler();
        GameScoreHandler gameScoreHandler = new GameScoreHandler();
        boolean gameFlag=true;
        int strikeCount = 0;
        List<Integer> computer = computerNumberGenerator.createNewNumber();
        while (strikeCount < 3) { // 사용자가 맞출 때까지
            List<Integer> user = userInputHandler.userInputThreeNumber();
            strikeCount = gameScoreHandler.calculateScore(computer, user);
            if (strikeCount == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int gameRestart = userInputHandler.userInputGameFlag();
                if (gameRestart==2){
                    gameFlag = false;
                }
            }
        }
        return gameFlag;
    }
}
