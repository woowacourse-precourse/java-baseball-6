package baseball.baseballGame;

import baseball.constants.Constants;
import baseball.gameRule.GameRule;
import baseball.numberGenerator.NumberGenerator;
import java.util.List;

public class BaseballGame {
    GameRule gameRule = new GameRule(); // gameRule 인스턴스 생성.
    NumberGenerator numberGenerator = new NumberGenerator(); // numberGenerator 인스턴스 생성
    private List<Integer> cpuGameNumber;
    private boolean gameAgainCheck = true;

    private void initializeGame() { // 게임 초기화
        System.out.println(Constants.START_MESSAGE);
        cpuGameNumber = numberGenerator.getCpuRandomNumber();
    }

    private void askToPlayAgain() { // 게임을 다시 할지 말지 물어봄
        System.out.println(Constants.END_MESSAGE);
        System.out.println(Constants.ASK_CONTINUE);
        gameAgainCheck = gameRule.playGameAgain(); // 게임을 다시 시작할지 말지 물어봄 1이면 true, 2면 false
        if (gameAgainCheck) {
            cpuGameNumber = numberGenerator.getCpuRandomNumber();
        }
    }

    private void printGameResult(int strikes, int balls, String nothing) { // 게임의 결과를 출력
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
    }

    private void playSingleGame() { // 게임의 한 사이클을 실행함. 플레이 시작 ~ 3strikes가 나올때까지
        int strikes;
        int balls;
        String nothing;

        while (true) {
            List<Integer> playerGameNumber = numberGenerator.getPlayerNumber();

            balls = gameRule.checkBall(playerGameNumber, cpuGameNumber);
            strikes = gameRule.checkStrike(playerGameNumber, cpuGameNumber);
            nothing = gameRule.checkNothing(playerGameNumber, cpuGameNumber);

            printGameResult(strikes, balls, nothing);

            if (gameRule.checkEndGame(strikes)) {
                break;
            }
        }
    }

    public void playWholeGame() { // 실제 전체 플레이
        initializeGame();
        while (gameAgainCheck) {
            playSingleGame();
            askToPlayAgain();
        }
        System.out.println(Constants.DECLARE_GAME_END);
    }
}


