package baseball.domain;

import java.util.List;

public class Referee {
    private int ball;

    private int strike;

    public Referee() {
        ball = 0;
        strike = 0;
    }

    public boolean isThreeStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        strike = 0;
        for (int i = 0; i < userNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);
            if (isStrike(computerNumber, userNumber)) {
                strike += 1;
            }
        }
        return strike == 3;
    }

    public void judge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < userNumbers.size(); i++) {
            int computerNumber = computerNumbers.get(i);
            int userNumber = userNumbers.get(i);
            if (isStrike(computerNumber, userNumber)) {
                strike += 1;
            }
            if (!isStrike(computerNumber, userNumber) && isBall(computerNumbers, userNumber)) {
                ball += 1;
            }
        }
        printJudgement(ball, strike);
    }

    private boolean isStrike(int computerNumber, int userNumber) {
        return computerNumber == userNumber;
    }

    private boolean isBall(List<Integer> computerNumbers, int userNumber) {
        return computerNumbers.contains(userNumber);
    }

    private void printJudgement(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        }
        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }
        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
