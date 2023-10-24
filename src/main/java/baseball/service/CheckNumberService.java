package baseball.service;

import java.util.List;

public class CheckNumberService {
    private int ball;
    private int strike;

    public CheckNumberService() {
        reset();
    }

    private void reset() {
        this.ball = 0;
        this.strike = 0;
    }
    public int[] checkNumber(List<Integer> userNumber, List<Integer> computerNumber) {
        reset();
        for (int i = 0; i<computerNumber.size(); i++) {
            if (userNumber.contains(computerNumber.get(i))) {
                ball++;
            }
            if (userNumber.get(i)==computerNumber.get(i)) {
                ball--;
                strike++;
            }
        }
        return new int [] {ball, strike};
    }
}
