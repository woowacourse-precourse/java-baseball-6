package baseball.service;

import java.util.List;

public class Service {
    private int strikes;
    private int balls;

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void setScore(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public Service() {
        this.strikes = 0;
        this.balls = 0;
    }

    public boolean isDigitStrike(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        return computerNumber.get(index).equals(userNumber.get(index));
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isDigitStrike(computerNumber, userNumber, index)) {
                count++;
            }
        }
        return count;
    }

    public boolean isDigitBall(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        if (isDigitStrike(computerNumber, userNumber, index)) {
            return false;
        }
        for (int cur = 0; cur < computerNumber.size(); cur++) {
            if (index == cur) {
                continue;
            }
            if (userNumber.get(index) == computerNumber.get(cur)) {
                return true;
            }
        }
        return false;
    }

    public int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isDigitBall(computerNumber, userNumber, index)) {
                count++;
            }
        }
        return count;
    }
}
