package baseball;

import java.util.List;

public class CheckNum {
    int finalStrike = 0;
    int finalBall = 0;

    public void checkNumber(List<Integer> randomNum, List<Integer> inputList) {
        checkStrike(randomNum, inputList);
        checkBall(randomNum, inputList);
        printResult(finalBall, finalStrike);
    }

    private void checkStrike(List<Integer> randomNum, List<Integer> inputList) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNum.get(i) == inputList.get(i)) {
                strike++;
            }
        }
        finalStrike = strike;
    }

    private void checkBall(List<Integer> randomNum, List<Integer> inputList) {
        int ball = 0;
        for (int num : inputList) {
            if (randomNum.contains(num)) {
                ball++;
            }
        }
        finalBall = ball - finalStrike;
    }

    private void printResult(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball > 0) {
            System.out.println(ball + "볼");
        } else if (strike > 0) {
            System.out.println(strike + "스트라이크");
        } else if (ball == 0 || strike == 0) {
            System.out.println("낫싱");
        }
    }
}
