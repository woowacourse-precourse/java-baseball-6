package baseball.domain;

import java.util.List;

public class Referee {

    private int ball;
    private int strike;

    public Referee() {
        ball = 0;
        strike = 0;
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
}
