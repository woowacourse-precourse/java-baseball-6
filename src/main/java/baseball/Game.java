package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private final ComputerSetting computerSetting;
    private final PlayerGame playerGame;

    public Game(ComputerSetting computerSetting, PlayerGame playerGame) {
        this.computerSetting = computerSetting;
        this.playerGame = playerGame;
    }

    public void gameInit() {
        while (true) {
            List<Integer> computer = computerSetting.computerNumberSetting();

            int[] ballCount;
            do {
                List<Integer> answerNumber = playerGame.playerNumber();

                ballCount = gameLogic(computer, answerNumber);

                if (ballCount[0] == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int selectNumber = Integer.parseInt(Console.readLine());
                    if (selectNumber == 1) {
                        break;
                    }
                    if (selectNumber == 2) {
                        return;
                    }
                }

                if (ballCount[0] == 0 && ballCount[1] == 0) {
                    System.out.println("낫싱");
                }
                if (ballCount[0] != 0 || ballCount[1] != 0) {
                    System.out.println(ballCount[1] + "볼 " + ballCount[0] + "스트라이크");
                }
            } while (ballCount[0] != 3);
        }
    }

    public int[] gameLogic(List<Integer> computer, List<Integer> answerNumber) {
        int strike = 0;
        int ball = 0;
        int check = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == answerNumber.get(i)) {
                strike++;
            }
        }
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(answerNumber.get(i))) {
                check++;
            }
        }
        ball = check - strike;

        return new int[]{strike, ball};
    }
}
