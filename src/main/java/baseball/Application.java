package baseball;
import java.util.*;링

public class Application {
    // main 함수
    public static void main(String[] args) {
        boolean restartGame = true;
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.sayStart();
        List<Integer> computer = baseballGame.getRandomThreeNum(); // System.out.println("[디버깅] computer: " + computer);

        while (restartGame) { // 게임 시작
            List<Integer> user = baseballGame.getThreeNum();
            baseballGame.calculateBallStrike(user, computer);
            baseballGame.sayBallStrike(baseballGame.ball, baseballGame.strike);
            if (baseballGame.strike == 3) {
                baseballGame.sayEnd();
                restartGame = baseballGame.determineRestart();
                computer = baseballGame.getRandomThreeNum(); // System.out.println("[디버깅] computer: " + computer);
            }
        }
    }

}
