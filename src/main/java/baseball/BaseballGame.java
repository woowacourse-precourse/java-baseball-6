package baseball;

import java.util.List;

public class BaseballGame {
    int LENGTH = 3;
    private Player player;
    private Computer computer;
    private static int ball;
    private static int strike;
    public boolean restart = true;

    BaseballGame() {
        player = new Player();
        computer = new Computer();
    }

    public void start() {
        boolean result = true;
        computer.createRandomNums();
        while (result) {
            player.setNums();
            result = checkResult();
        }
        restart = player.getRestart();
    }

    private boolean checkResult() {
        strike = 0;
        ball = 0;
        compareNums();
        printResult();
        return strike != 3;
    }

    private void compareNums() {
        List<Integer> playerNums = player.getPlayerNums();
        List<Integer> randomNums = computer.getRandomNums();

        for (int i = 0; i < LENGTH; i++) {
            countStrike(i, randomNums.get(i), playerNums);
            countBall(i, randomNums.get(i), playerNums);
        }
    }

    private void countStrike(int idx, int randomNum, List<Integer> playerNums) {
        for (int i = 0; i < LENGTH; i++) {
            if (randomNum == playerNums.get(i) && idx == i) {
                strike++;
            }
        }
    }

    private void countBall(int idx, int randomNum, List<Integer> playerNums) {
        for (int i = 0; i < LENGTH; i++) {
            if (randomNum == playerNums.get(i) && idx != i) {
                ball++;
            }
        }
    }

    private void printResult() {
        if (ball > 0) {
            System.out.print(ball + "볼");
            System.out.print(" ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strike == 3) {
            System.out.println(LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }
}
