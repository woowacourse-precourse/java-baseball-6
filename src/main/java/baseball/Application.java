package baseball;

import baseball.constants.Constants;
import baseball.gameRule.GameRule;
import baseball.numberGenerator.NumberGenerator;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        baseballGame baseballgame = new baseballGame();
        baseballgame.playGame();
    }
}

class baseballGame {

    public void playGame() {
        int balls;
        int strikes;
        String nothing;
        boolean gameAgainCheck = true;
        GameRule gameRule = new GameRule(); // gameRule 인스턴스 생성.
        NumberGenerator numberGenerator = new NumberGenerator(); // numberGenerator 인스턴스 생성

        System.out.println(Constants.START_MESSAGE);
        List<Integer> cpuGameNumber = numberGenerator.getCpuRandomNumber();

        while (true) { // gameAgainCheck 가 false가 되년 경우엔 게임 종료
            List<Integer> playerGameNumber = numberGenerator.getPlayerNumber();
            strikes = gameRule.checkStrike(playerGameNumber, cpuGameNumber);
            balls = gameRule.checkBall(playerGameNumber, cpuGameNumber);
            nothing = gameRule.checkNothing(playerGameNumber, cpuGameNumber);

            if (nothing.equals("낫싱")) { // 하나도 맞는 경우가 없는 경우
                System.out.println("낫싱");
            }
            if (strikes != 0 && balls == 0) { // 스트라이크만 있는 경우
                System.out.println(strikes + "스트라이크");
            }
            if (strikes == 0 && balls != 0) { // 볼만 있는 경우
                System.out.println(balls + "볼");
            }
            if (strikes != 0 && balls != 0) { // 볼과 스트라이크 모두 있는 경우
                System.out.println(balls + "볼 " + strikes + "스트라이크");
            }
            if (gameRule.checkEndGame(strikes)) { // 게임이 끝났는지 안끝났는지 확인함. strikes = 3 이면 진입
                System.out.println(Constants.END_MESSAGE);
                System.out.println(Constants.ASK_CONTINUE);
                gameAgainCheck = gameRule.playGameAgain(); // 게임을 다시 시작할지 말지 물어봄 1이면 true, 2면 false
                if (!gameAgainCheck) {
                    break;
                }
                cpuGameNumber = numberGenerator.getCpuRandomNumber();
            }
        }
        System.out.println(Constants.DECLARE_GAME_END);
    }
}