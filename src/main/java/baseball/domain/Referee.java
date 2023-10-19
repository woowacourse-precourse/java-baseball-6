package baseball.domain;

import java.util.List;

public class Referee {

    private int ball = 0;
    private int strike = 0;
    private String judgement = "";

    public Referee(List<Integer> computerNumbers, List<Integer> userNumbers) {
        judge(computerNumbers, userNumbers);
        judgement = result(ball, strike);
    }

    private String result(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    private void judge(List<Integer> computerNumbers, List<Integer> userNumbers) {
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
    }

    private boolean isStrike(int computerNumber, int userNumber) {
        return computerNumber == userNumber;
    }

    private boolean isBall(List<Integer> computerNumbers, int userNumber) {
        return computerNumbers.contains(userNumber);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public String getJudgement() {
        return judgement;
    }
}
