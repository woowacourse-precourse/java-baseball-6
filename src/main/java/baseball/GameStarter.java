package baseball;

import com.sun.source.tree.BreakTree;

import java.util.List;

public class GameStarter {
    public static boolean newGame(){
        boolean gameFlag=true;
        int strikeCount = 0;
        List<Integer> computer = ComputerNumberGenerator.createNewNumber();
        while (strikeCount < 3) { // 사용자가 맞출 때까지
            List<Integer> user = UserInputHandler.userInputThreeNumber();
            strikeCount = GameScoreHandler.calculateScore(computer, user);
            if (strikeCount == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int gameRestart = UserInputHandler.userInputGameFlag();
                if (gameRestart==2){
                    gameFlag = false;
                }
            }
        }
        return gameFlag;
    }
}
