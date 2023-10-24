package baseball.core;

import java.util.List;

public class Core {
    public int countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        System.out.println("스트라이크 확인 합시다!!");
        int size = playerNumbers.size();
        int strike = 0;
        for (int index = 0; index < size; index++) {
            if (isStrike(computerNumbers, playerNumbers, index)) {
                strike++;
            }
        }
        return strike;
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> playerNumbers, int index) {
        return computerNumbers.get(index).equals(playerNumbers.get(index));
    }

    public int countBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        System.out.println("볼 확인 합시다!");
        int size = playerNumbers.size();
        int ball = 0;
        for (int index = 0; index < size; index++) {
            if (isBall(computerNumbers, playerNumbers, index)) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isBall(List<Integer> computerNumbers, List<Integer> playerNumbers, int index) {
        boolean result = false;

        int size = computerNumbers.size();
        for (int diff = 0; diff < size; diff++) {
            if (index != diff) {
                result = currentBall(playerNumbers.get(index), computerNumbers.get(diff));
            }
            if (result) { // 볼이 발견되면 반복 멈춤!
                break;
            }
        }
        return result;
    }

    private boolean currentBall(int computerNumber, int playerNumber) {
        return computerNumber == playerNumber;
    }

    public void printToResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        }
    }
}
