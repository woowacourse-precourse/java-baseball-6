package baseball.domain;

import java.util.List;

public class Strike {

    private final int strike;

    public Strike(int strike) {

        this.strike = strike;
    }

    public static int calculateStrikeCnt(List<Integer> answerNumbers, Balls balls) {

        int strike = 0;

        for(int i = 0; i < answerNumbers.size(); i++) {
            for(int j = 0; j < balls.getBalls().size(); j++) {
                if((i == j) && (answerNumbers.get(i) == balls.getBalls().get(j))) {
                    strike++;
                }
            }
        }

        return strike;
    }

    public boolean isAllStrike() {

        if(strike == 3) {
            return true;
        }
        return false;
    }

    public int getStrike() {

        return strike;
    }
}
